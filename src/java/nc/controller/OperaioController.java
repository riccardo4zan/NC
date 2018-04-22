package nc.controller;

import nc.model.Elaborazione;
import nc.model.Segnalazione;
import nc.service.ElaborazioneService;
import nc.service.SegnalazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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
    ElaborazioneService es;
    
    @Autowired
    SegnalazioneService ss;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        //inserire qui elaborazioni aperte
        model.addObject("matricola",MainController.getLoggedDip().getMatricola());
        model.addObject("aperte", es.findOpen(MainController.getLoggedDip()));
        model.setViewName("indexOperaio");
        return model;
    }
    
    @RequestMapping(value = {"/old"}, method = RequestMethod.GET)
    public ModelAndView old() {
        ModelAndView model = new ModelAndView();
        //inserire qui elaborazioni aperte
        model.addObject("matricola",MainController.getLoggedDip().getMatricola());
        model.addObject("chiuse", es.findClose(MainController.getLoggedDip()));
        model.setViewName("indexOperaio");
        return model;
    }
    
    //manca request param
    @RequestMapping(value = {"/editElaborazione"}, method = RequestMethod.GET)
    public ModelAndView modifica(@ModelAttribute("elaborazione")Elaborazione e) {
        ModelAndView model = new ModelAndView();
        //inserire qui codice elaborazione da parametro
        es.updateElaborazione(e);
        model.addObject("matricola",MainController.getLoggedDip().getMatricola());
        model.addObject("idElaborazione", e.getCodice());
        model.setViewName("indexOperaio");
        return model;
    }
    

    //manca request param
    @RequestMapping(value = {"/news"}, method = RequestMethod.GET)
    public ModelAndView segnalazione() {
        ModelAndView model = new ModelAndView();
        //inserire qui codice elaborazione da parametro
        model.addObject("matricola",MainController.getLoggedDip().getMatricola());
        model.addObject("segnalazione", "si");
        model.setViewName("indexOperaio");
        return model;
    }
    
    @RequestMapping(value = {"/addS"}, params={"desc", "titolo"}, method = RequestMethod.GET)
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
    
}
