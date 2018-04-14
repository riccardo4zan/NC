package nc.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/op**")
@ComponentScan("nc.dao")
public class OperaioController {

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        //inserire qui elaborazioni aperte
        model.addObject("elaborazioniAperte", "quiElaborazioniAperte");
        model.setViewName("indexOperaio");
        return model;
    }
    
    @RequestMapping(value = {"/old"}, method = RequestMethod.GET)
    public ModelAndView old() {
        ModelAndView model = new ModelAndView();
        //inserire qui elaborazioni chiuse
        model.addObject("elaborazioniChiuse", "quiElaborazioniChiuse");
        model.setViewName("indexOperaio");
        return model;
    }
    
    //manca request param
    @RequestMapping(value = {"/modifica"}, method = RequestMethod.GET)
    public ModelAndView modifica() {
        ModelAndView model = new ModelAndView();
        //inserire qui codice elaborazione da parametro
        model.addObject("elaborazione", "codiceElaborazione");
        model.setViewName("indexOperaio");
        return model;
    }
    
}
