/**
 * Controller che gestisce le azioni che possono essere compiute dal responsabile qualità
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
@RequestMapping("/rq")
@ComponentScan("nc.dao")
public class RQualitaController {
    
}
