/**
 * Controller che gestisce le azioni che possono essere compiute dal manager
 */
package nc.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author riccardo
 */
@Controller
@RequestMapping("/manager")
@ComponentScan("nc.dao")
public class ManagerController {
    
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        return "indexManager";
    }
}
