package nc.controller;

import nc.service.ElaborazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/op**")
@ComponentScan("nc.dao")
public class OperaioController {
    
    @Autowired
    ElaborazioneService es;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        //inserire qui elaborazioni aperte
        model.addObject("matricola",MainController.loggedDip.getMatricola());
        model.addObject("aperte", es.findOpen(MainController.loggedDip));
        model.addObject("chiuse", es.findClose(MainController.loggedDip));
        model.setViewName("indexOperaio");
        return model;
    }
    
    //manca request param
    @RequestMapping(value = {"/mod"}, method = RequestMethod.GET)
    public ModelAndView modifica() {
        ModelAndView model = new ModelAndView();
        //inserire qui codice elaborazione da parametro
        model.addObject("idElaborazione", "codiceElaborazione");
        model.setViewName("indexOperaio");
        return model;
    }
    
    //manca request param
    @RequestMapping(value = {"/news"}, method = RequestMethod.GET)
    public ModelAndView segnalazione() {
        ModelAndView model = new ModelAndView();
        //inserire qui codice elaborazione da parametro
        model.addObject("segnalazione", "si");
        model.setViewName("indexOperaio");
        return model;
    }
    
}
