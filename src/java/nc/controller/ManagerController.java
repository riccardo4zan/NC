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
    private NonConformitaService ncs;
    @Autowired
    private TipoService ts;
    @Autowired
    private RepartoService rs;
    @Autowired
    private FornitoreService fs;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        int anno = Calendar.getInstance().get(Calendar.YEAR);

        //inserire qui elaborazioni aperte
        model.addObject("matricola", MainController.getLoggedDip().getMatricola());

        // prendo tutti i tipi, i reparti e i fornitori presenti
        List<Reparto> reparti = rs.findAll();
        List<Fornitore> fornitori = fs.findAll();
        List<Tipo> tipi = ts.findAll();
        
        model.addObject("sponi", reparti);
        model.addObject("triplo", fornitori);
        model.addObject("rete", tipi);

        //ricavo i dati riguardanti tipi, reparti e fornitori presenti
        ArrayList<ChartData> repartiData = new ArrayList<>();
        ArrayList<ChartData> fornitoriData = new ArrayList<>();
        ArrayList<ChartData> tipiData = new ArrayList<>();

        for (Fornitore tmp : fornitori) {
            double costo = ncs.findCostoPerFornitore(anno, tmp);
            if (costo != 0) {
                fornitoriData.add(new ChartData(tmp.getPiva(), costo));
            }
        }
        for (Reparto tmp : reparti) {
            double costo = ncs.findCostoPerReparto(anno, tmp);
            if (costo != 0) {
                repartiData.add(new ChartData(tmp.getNome(), costo));
            }
        }
        for (Tipo tmp : tipi) {
            double costo = ncs.findCostoPerTipo(anno, tmp);
            if (costo != 0) {
                tipiData.add(new ChartData(tmp.getNome(), costo));
            }
        }

        model.addObject("repartiData", repartiData);
        model.addObject("tipiData", tipiData);
        model.addObject("fornitoriData", fornitoriData);

        model.setViewName("indexManager");
        return model;
    }

}
