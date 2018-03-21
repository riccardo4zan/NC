package nc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import nc.service.DipendenteService;
 
@Controller
@RequestMapping("/")
@ComponentScan("nc.dao")
public class MainController {
    
    @Autowired
    DipendenteService dip;
    
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = {"/listDipendenti"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("Dipendenti",dip.findAll());
        return "listDipendenti";
    }
    
}
