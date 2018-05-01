package nc.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import nc.model.Categoria;
import nc.model.Fornitore;
import nc.model.Reparto;
import nc.model.Tipo;
import nc.model.User;
import nc.service.CategoriaService;
import nc.service.FornitoreService;
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
@RequestMapping("/ma**")
@ComponentScan("nc.dao")
public class ManagerController {

    @Autowired
    private CategoriaService cs;

    @Autowired
    private NonConformitaService ncs;

    @Autowired
    private TipoService ts;

    @Autowired
    private RepartoService rs;

    @Autowired
    private FornitoreService fs;

    @Autowired
    private UserService us;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        int anno = Calendar.getInstance().get(Calendar.YEAR);

        //inserire qui elaborazioni aperte
        model.addObject("matricola", MainController.getLoggedDip().getMatricola());

        //dati thumbnais
        double presente = ncs.findCostoNCPerAnno(anno), passato = ncs.findCostoNCPerAnno(anno - 1);
        model.addObject("totale", presente);
        model.addObject("ncAnno", ncs.findNumeroNCAnno(anno));
        if (passato != 0) {
            model.addObject("differenza", ((presente - passato) * 100) / passato);
        } else {
            model.addObject("differenza", 0);
        }

        // prendo tutti i tipi, i reparti e i fornitori presenti
        List<Reparto> reparti = rs.findAll();
        List<Fornitore> fornitori = fs.findAll();
        List<Tipo> tipi = ts.findAll();

        //ricavo i dati riguardanti tipi, reparti e fornitori presenti
        ArrayList<ChartData> repartiData = new ArrayList<>();
        ArrayList<ChartData> fornitoriData = new ArrayList<>();
        ArrayList<ChartData> tipiData = new ArrayList<>();

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

        model.setViewName("indexManager");
        return model;
    }

    @RequestMapping(value = "/creaCategoria", method = RequestMethod.GET)
    public ModelAndView creaCategoria() {
        ModelAndView model = new ModelAndView();
        model.addObject("categoria", true);
        model.setViewName("indexManager");
        return model;
    }

    @RequestMapping(value = "/addCat", params = {"desc"}, method = RequestMethod.GET)
    public ModelAndView aggiungiCategoria(@RequestParam("desc") String desc) {
        ModelAndView model = new ModelAndView();
        Categoria nuovaC = new Categoria(desc);
        cs.saveCategoria(nuovaC);
        model.addObject("ruolo", MainController.getLoggedDip().getUser().getUserRole().iterator().next().getRole());
        model.setViewName("redirect");
        return model;
    }

    @RequestMapping(value = {"/dati"}, method = RequestMethod.GET)
    public ModelAndView visualizzaDati() {
        ModelAndView model = new ModelAndView();
        model.addObject("datiPersonali", MainController.getLoggedDip());
        model.setViewName("indexManager");
        return model;
    }

    @RequestMapping(value = {"/cambiaPassword"}, method = RequestMethod.GET)
    public ModelAndView cambiaPassword() {
        ModelAndView model = new ModelAndView();
        //Passo un valore true per permettere l'inclusione del frammento di codice relativo al cambio della password
        model.addObject("changePassword", true);
        model.setViewName("indexManager");
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