package nc.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import nc.model.NonConformita;
import nc.model.Reparto;
import nc.model.User;
import nc.service.DipendenteService;
import nc.service.NonConformitaService;
import nc.service.RepartoService;
import nc.service.TipoService;
import nc.service.UserService;
import nc.utility.ChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rq**")
@ComponentScan("nc.dao")
public class RQualitaController {

    @Autowired
    private RepartoService rs;
    
    @Autowired
    private TipoService ts;

    @Autowired
    private NonConformitaService ncs;

    @Autowired
    private DipendenteService ds;

    @Autowired
    private UserService us;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        int anno = Calendar.getInstance().get(Calendar.YEAR);
        
        // dati per thumbnails e grafici a torta
        int aperte = ncs.findAllAperte().size();
        int elaborazione = ncs.findAllInElaborazione().size();
        int chiuse = ncs.findAllChiuse().size();
        
        int repartiNC = ncs.findNumeroNCReparti(anno);
        int fornitoriNC = ncs.findNumeroNCFornitori(anno);
        int clientiNC = ncs.findNumeroNCClienti(anno);
        
        //inserire qui elaborazioni aperte
        model.addObject("matricola", MainController.getLoggedDip().getMatricola());

        //dati thumbnais
        model.addObject("ncAnno", ncs.findNumeroNCAnno(anno));
        model.addObject("ncAperte", aperte+elaborazione);
        model.addObject("tipoNC", ncs.findTipoNCProblematico());
        
        // prendo tutti i tipi, i reparti e i fornitori presenti
        List<Reparto> reparti = rs.findAll();

        //ricavo i dati riguardanti tipi, reparti e fornitori presenti
        ArrayList<ChartData> repartiData = new ArrayList<>();
        ArrayList<ChartData> tipiData = new ArrayList<>();
        ArrayList<ChartData> interneEsterne = new ArrayList<>();
        
        if(aperte>0) tipiData.add(new ChartData("Aperte", aperte));
        if(elaborazione>0) tipiData.add(new ChartData("In elaborazione", elaborazione));
        if(chiuse>0) tipiData.add(new ChartData("Chiuse", chiuse));
        
        if(repartiNC>0) interneEsterne.add(new ChartData("reparti", repartiNC));
        if(fornitoriNC>0) interneEsterne.add(new ChartData("fornitori", fornitoriNC));
        if(clientiNC>0) interneEsterne.add(new ChartData("clienti", clientiNC));
        
        for (Reparto tmp : reparti) {
            int num = ncs.findNumeroNCPerReparto(anno, tmp.getId());
            if (num != 0) {
                repartiData.add(new ChartData(tmp.getNome(), num));
            }
        }
        
        model.addObject("tipiData", tipiData);
        model.addObject("repartiData", repartiData);
        model.addObject("interneEsterne", interneEsterne);
        
        // ricavo dati istogramma
        ArrayList<ChartData> istogramma = new ArrayList<>();
        String[] mesi = {"", "Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
        double max = 0;
        for (int i = 1; i <= 12; i++) {
            istogramma.add(new ChartData(mesi[i], ncs.findNumAnnoPerMese(i, anno)));
        }
        model.addObject("istogramma", istogramma);

        model.setViewName("indexRQualita");
        return model;
    }

    /**
     * Dati da prendere dal requestParam Data apertura Tipo Descrizione Piva
     * Fornitore oppure ID reparto oppure PivaCliente (controllo se uno di
     * questi ha un valore valido)
     */
    @RequestMapping(value = {"/addNC"}, method = RequestMethod.GET)
    public ModelAndView addNC() {
        ModelAndView model = new ModelAndView();
        //Creando la NC e precompilando i campi
        NonConformita newnc = new NonConformita();
        newnc.setDipendente(MainController.getLoggedDip());
        model.addObject("newnc", newnc);
        //Passo tutta la lista dei possibili tipi di NC
        model.addObject("scrollerTipo", ts.findAll());
        /**
         * NOME DELLA VIEW PER AGGIUNGERE NUOVE NC
         */
        model.setViewName("");
        return model;
    }

    /**
     * MANCA METODO PER SALVARE LA NC
     */
    /**
     * Passami il codice della NonConformità attraverso il GET o il post
     *
     * Bottone accanto al nome della NC nella lista che se cliccato manda alla
     * pagina di gestione del team delle NC
     *
     * @return
     */
    @RequestMapping(value = {"/teamNC"}, method = RequestMethod.GET)
    public ModelAndView teamNC(@RequestParam(value = "codiceNC") int codice) {
        ModelAndView model = new ModelAndView();
        //Prendo la NC dal codice
        NonConformita tm = ncs.findByCodice(codice);
        //Passo tutta la lista dei possibili dipendenti associabili al team
        model.addObject("scrollerDip", ds.findAll());
        //Passo la lista dei dipendenti già associati al team
        model.addObject("dipendentiAssociati", tm.getTeam());

        /**
         * NOME DELLA VIEW PER AGGIUNGERE AL TEAM
         */
        model.setViewName("");
        return model;
    }

    /**
     * MANCA METODO PER IL TEAM OPERATIVO
     */
    @RequestMapping(value = {"/dati"}, method = RequestMethod.GET)
    public ModelAndView visualizzaDati() {
        ModelAndView model = new ModelAndView();
        model.addObject("datiPersonali", MainController.getLoggedDip());
        model.setViewName("indexRQualita");
        return model;
    }

    @RequestMapping(value = {"/cambiaPassword"}, method = RequestMethod.GET)
    public ModelAndView cambiaPassword() {
        ModelAndView model = new ModelAndView();
        //Passo un valore true per permettere l'inclusione del frammento di codice relativo al cambio della password
        model.addObject("changePassword", true);
        model.setViewName("indexRQualita");
        return model;
    }

    @RequestMapping(value = {"/saveNewPasswd"}, params = {"psswd1"}, method = RequestMethod.POST)
    public ModelAndView savePassword(@RequestParam("psswd1") String psswd) {
        ModelAndView model = new ModelAndView();
        //Controllo e cambio della password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hpsswd = passwordEncoder.encode(psswd);
        User u = MainController.getLoggedDip().getUser();
        u.setPassword(hpsswd);
        us.updateUser(u);
        model.addObject("ruolo", MainController.getLoggedDip().getUser().getUserRole().iterator().next().getRole());
        model.setViewName("/redirect");
        return model;
    }
}
