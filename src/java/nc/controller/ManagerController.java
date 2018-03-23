/**
 * Controller che gestisce le azioni che possono essere compiute dal manager
 */
package nc.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author riccardo
 */
@Controller
@RequestMapping("/manager")
@ComponentScan("nc.dao")
public class ManagerController {
    
}
