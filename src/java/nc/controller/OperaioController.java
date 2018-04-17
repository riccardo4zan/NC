package nc.controller;

import nc.model.Elaborazione;
import nc.model.Segnalazione;
import nc.service.ElaborazioneService;
import nc.service.SegnalazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value = {"/mod"}, method = RequestMethod.GET)
    public ModelAndView modifica() {
        ModelAndView model = new ModelAndView();
        //inserire qui codice elaborazione da parametro
        model.addObject("matricola",MainController.getLoggedDip().getMatricola());
        model.addObject("idElaborazione", "codiceElaborazione");
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
    
        @RequestMapping(value = {"/addS"}, method = RequestMethod.POST)
    public ModelAndView addSegnalazione(@ModelAttribute Segnalazione s) {
        ModelAndView model = new ModelAndView();
        ss.saveSegnalazione(s);
        //inserire qui codice elaborazione da parametro
        model.addObject("matricola",MainController.getLoggedDip().getMatricola());
        model.setViewName("indexOperaio");
        return model;
    }
    
}
