package nc.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import nc.model.Fornitore;
import nc.model.Reparto;
import nc.model.Tipo;
import nc.service.FornitoreService;
import nc.service.NonConformitaService;
import nc.service.RepartoService;
import nc.service.TipoService;
import nc.utility.ChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ma**")
@ComponentScan("nc.dao")
public class ManagerController {
    
    @Autowired
    NonConformitaService ncs;
    
    @Autowired 
    TipoService ts;
    
    @Autowired
    RepartoService rs;
    
    @Autowired
    FornitoreService fs;
    
    
    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        int anno = Calendar.getInstance().get(Calendar.YEAR);
        
        //inserire qui elaborazioni aperte
        model.addObject("matricola",MainController.getLoggedDip().getMatricola());
        
        // prendo tutti i tipi, i reparti e i fornitori presenti
        List<Reparto> reparti = rs.findAll();
        List<Fornitore> fornitori = fs.findAll();
        List<Tipo> tipi = ts.findAll();
        
        //ricavo i dati riguardanti tipi, reparti e fornitori presenti
        List<ChartData> fornitoriData = new ArrayList<>();
        List<ChartData> tipiData = new ArrayList<>();
        List<ChartData> repartiData = new ArrayList<>();
        
        for(Fornitore tmp : fornitori) {
            fornitoriData.add(new ChartData(tmp.getPiva(), ncs.findCostoPerFornitore(anno, tmp)));
        }
        for(Reparto tmp : reparti) {
            repartiData.add(new ChartData(tmp.getNome(), ncs.findCostoPerReparto(anno, tmp)));
        }
        for(Tipo tmp : tipi) {
            tipiData.add(new ChartData(tmp.getNome(), ncs.findCostoPerTipo(anno, tmp)));
        }
        
        model.addObject("repartiData", repartiData);
        model.addObject("tipiData", tipiData);
        model.addObject("fornitoriData", fornitoriData);
        
        model.setViewName("indexManager");
        return model;
    }
    
}
