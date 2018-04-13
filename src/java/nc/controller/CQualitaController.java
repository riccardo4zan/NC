package nc.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cq**")
@ComponentScan("nc.dao")
public class CQualitaController {

    @RequestMapping(value = {"/index", ""}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        return "indexCQualita";
    }
}
