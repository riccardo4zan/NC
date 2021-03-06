package nc.controller;

import nc.model.Categoria;
import nc.model.Elaborazione;
import nc.model.Pezzo;
import nc.model.Segnalazione;
import nc.model.User;
import nc.service.CategoriaService;
import nc.service.ElaborazioneService;
import nc.service.PezzoService;
import nc.service.SegnalazioneService;
import nc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/op**")
@ComponentScan("nc.dao")
public class OperaioController {

    @Autowired
    CategoriaService cs;

    @Autowired
    PezzoService ps;

    @Autowired
    ElaborazioneService es;

    @Autowired
    SegnalazioneService ss;

    @Autowired
    private UserService us;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.addObject("matricola", MainController.getLoggedDip().getMatricola());
        model.addObject("aperte", es.findOpen(MainController.getLoggedDip()));
        model.setViewName("indexOperaio");
        return model;
    }

    @RequestMapping(value = {"/old"}, method = RequestMethod.GET)
    public ModelAndView old() {
        ModelAndView model = new ModelAndView();
        model.addObject("matricola", MainController.getLoggedDip().getMatricola());
        model.addObject("chiuse", es.findClose(MainController.getLoggedDip()));
        model.setViewName("indexOperaio");
        return model;
    }

    @RequestMapping(value = {"/prod"}, method = RequestMethod.GET)
    public ModelAndView prod() {
        ModelAndView model = new ModelAndView();
        model.addObject("matricola", MainController.getLoggedDip().getMatricola());
        model.addObject("categorie", cs.findAllCategorie());
        model.setViewName("indexOperaio");
        return model;
    }

    @RequestMapping(value = {"/editElaborazione"},params={"codice"}, method = RequestMethod.GET)
    public ModelAndView modifica(@RequestParam("codice") int codice) {
        ModelAndView model = new ModelAndView();
        model.addObject("matricola", MainController.getLoggedDip().getMatricola());
        model.addObject("elaborazione", es.findByCodice(codice));
        model.setViewName("indexOperaio");
        return model;
    }

    @RequestMapping(value = {"/news"}, method = RequestMethod.GET)
    public ModelAndView segnalazione() {
        ModelAndView model = new ModelAndView();
        //inserire qui codice elaborazione da parametro
        model.addObject("matricola", MainController.getLoggedDip().getMatricola());
        model.addObject("segnalazione", true);
        model.setViewName("indexOperaio");
        return model;
    }

    @RequestMapping(value = {"/addS"}, params = {"desc", "titolo"}, method = RequestMethod.GET)
    public ModelAndView addSegnalazione(@RequestParam("desc") String desc, @RequestParam("titolo") String titolo) {
        ModelAndView model = new ModelAndView();
        Segnalazione s = new Segnalazione(desc, titolo);
        s.setDipendente(MainController.getLoggedDip());
        ss.saveSegnalazione(s);
        //inserire qui codice elaborazione da parametro
        model.addObject("ruolo", MainController.getLoggedDip().getUser().getUserRole().iterator().next().getRole());
        model.setViewName("redirect");
        return model;
    }

    @RequestMapping(value = {"/dati"}, method = RequestMethod.GET)
    public ModelAndView visualizzaDati() {
        ModelAndView model = new ModelAndView();
        model.addObject("datiPersonali", MainController.getLoggedDip());
        model.setViewName("indexOperaio");
        return model;
    }

    @RequestMapping(value = {"/cambiaPassword"}, method = RequestMethod.GET)
    public ModelAndView cambiaPassword() {
        ModelAndView model = new ModelAndView();
        model.addObject("changePassword", true);
        model.setViewName("indexOperaio");
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

    @RequestMapping(value = {"/addProd"}, params = {"categoria", "numero"}, method = RequestMethod.GET)
    public ModelAndView addProdotto(@RequestParam("categoria") String categoria, @RequestParam("numero") int numero) {
        ModelAndView model = new ModelAndView();

        int idCat = Integer.parseInt(categoria);
        Categoria tmp = cs.findByCodice(idCat);
        int min = ps.findMaxID() + 1;
        for (int i = 0; i < numero; i++) {
            Pezzo pz = new Pezzo();
            pz.setCategoria(tmp);
            ps.savePezzo(pz);
        }
        int max = ps.findMaxID();
        model.addObject("ruolo", MainController.getLoggedDip().getUser().getUserRole().iterator().next().getRole());
        model.setViewName("/redirect");
        return model;
    }
    
    @RequestMapping(value = {"/modEla"}, method = RequestMethod.POST)
    public ModelAndView modificaElaborazione(@ModelAttribute("elaborazione") Elaborazione e) {
        ModelAndView model = new ModelAndView();
        es.updateElaborazione(e);
        model.addObject("ruolo", MainController.getLoggedDip().getUser().getUserRole().iterator().next().getRole());
        model.setViewName("/redirect");
        return model;
    }

}