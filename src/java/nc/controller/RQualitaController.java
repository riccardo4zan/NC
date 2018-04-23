package nc.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import nc.model.Fornitore;
import nc.model.NonConformita;
import nc.model.Reparto;
import nc.model.Tipo;
import nc.model.User;
import nc.service.DipendenteService;
import nc.service.NonConformitaService;
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

        //inserire qui elaborazioni aperte
        model.addObject("matricola", MainController.getLoggedDip().getMatricola());

        //dati thumbnais
        model.addObject("ncAnno", ncs.findNumeroNCAnno(anno));
        model.addObject("ncAperte", ncs.findAllAperte().size()+ncs.findAllInElaborazione().size());
        model.addObject("tipoNC", ncs.findTipoNCProblematico());
        
        // prendo tutti i tipi, i reparti e i fornitori presenti
       

        //ricavo i dati riguardanti tipi, reparti e fornitori presenti
        ArrayList<ChartData> repartiData = new ArrayList<>();
        ArrayList<ChartData> fornitoriData = new ArrayList<>();
        ArrayList<ChartData> tipiData = new ArrayList<>();

        /**
        for (Fornitore tmp : fornitori) {
            double costo = ncs.findCostoPerFornitore(anno, tmp);
            if (costo != 0) {
                fornitoriData.add(new ChartData(tmp.getNome(), costo));
            }
        }
        for (Reparto tmp : reparti) {
            double costo = ncs.findCostoPerReparto(anno, tmp);
            if (costo != 0) {
                repartiData.add(new ChartData(tmp.getNome(), costo));
            }
        }
        for (Tipo tmp : tipi) {
            double costo = ncs.findCostoPerTipo(anno, tmp);
            if (costo != 0) {
                tipiData.add(new ChartData(tmp.getNome(), costo));
            }
        }
        model.addObject("repartiData", repartiData);
        model.addObject("tipiData", tipiData);
        model.addObject("fornitoriData", fornitoriData);

        // ricavo dati istogramma
        ArrayList<ChartData> istogramma = new ArrayList<>();
        String[] mesi = {"", "Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
        double max = 0;
        for (int i = 1; i <= 12; i++) {
            double costo = ncs.findCostoAnnoPerMese(i, anno);
            if (costo > max) {
                max = costo;
            }
            istogramma.add(new ChartData(mesi[i], costo));
        }
        model.addObject("istogramma", istogramma);
        model.addObject("max", max);
        */
        model.setViewName("indexManager");
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
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/cambiaPassword"}, method = RequestMethod.GET)
    public ModelAndView cambiaPassword() {
        ModelAndView model = new ModelAndView();
        //Passo un valore true per permettere l'inclusione del frammento di codice relativo al cambio della password
        model.addObject("changePassword", true);
        model.setViewName("indexCQualita");
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
