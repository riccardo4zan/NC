package nc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import nc.dao.DipendenteDao;
 
@Controller
@RequestMapping("/")
@ComponentScan("nc.dao")
public class MainController {
    
    /**
     * TODO:
     * - Cambiare la dipendenza da DipendenteDao e impostarla sul service
     * - Togliere transactional dai DaoImpl
     */
    
    @Autowired
    DipendenteDao dip;
    
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
