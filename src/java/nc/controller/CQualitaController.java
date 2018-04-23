package nc.controller;

import java.util.List;
import nc.model.Cliente;
import nc.model.Fornitore;
import nc.model.NonConformita;
import nc.model.Reparto;
import nc.model.Tipo;
import nc.service.ClienteService;
import nc.service.DipendenteService;
import nc.service.FornitoreService;
import nc.service.NonConformitaService;
import nc.service.RepartoService;
import nc.service.SegnalazioneService;
import nc.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cq**")
@ComponentScan("nc.dao")
public class CQualitaController {

    @Autowired
    private SegnalazioneService ss;

    @Autowired
    private TipoService ts;

    @Autowired
    private FornitoreService fs;

    @Autowired
    private ClienteService cs;

    @Autowired
    private NonConformitaService ncs;

    @Autowired
    private RepartoService rs;

    @Autowired
    private DipendenteService ds;

    @RequestMapping(value = {"/index", ""}, method = RequestMethod.GET)
    public String index() {
        ModelAndView model = new ModelAndView();
        List<NonConformita> nc=ncs.findAllAperte();
        if(nc.isEmpty())model.addObject("Vuoto", "Non ci sono non conformità aperte");
        model.addObject("NCAperte",nc);
        model.addObject("Matricola", MainController.getLoggedDip().getMatricola());
        return "indexCQualita";
    }

    @RequestMapping(value = {"/NCElaborazione"}, method = RequestMethod.GET)
    public String NCElaborazione() {
        ModelAndView model = new ModelAndView();
        List<NonConformita> nc=ncs.findAllInElaborazione();
        if(nc.isEmpty())model.addObject("Vuoto", "Non ci sono non conformità in elaborazione");
        model.addObject("NCElaborazione",nc);
        model.addObject("Matricola", MainController.getLoggedDip().getMatricola());
        return "indexCQualita";
    }

    @RequestMapping(value = {"/NCChiuse"}, method = RequestMethod.GET)
    public String NCChiuse() {
        ModelAndView model = new ModelAndView();
        List<NonConformita> nc=ncs.findAllChiuse();
        if(nc.isEmpty())model.addObject("Vuoto", "Non ci sono non conformità chiuse");
        model.addObject("NCChiuse",nc);
        model.addObject("Matricola", MainController.getLoggedDip().getMatricola());
        return "indexCQualita";
    }

    @RequestMapping(value = {"/apriNC"}, params = {"desc"}, method = RequestMethod.GET)
    public ModelAndView NC(@RequestParam(value = "desc", required=false) String descrizione) {
        ModelAndView model = new ModelAndView();
        model.addObject("Tipi", ts.findAll());
        model.addObject("Reparti", rs.findAll());
        model.addObject("Fornitori", fs.findAll());
        model.addObject("Clienti", cs.findAll());
        model.addObject("Descrizione",descrizione);
        model.addObject("NC", "si");
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/addNC"}, params = {"desc", "azioniContenimento", "cause", "gravita", "tipo", "reparto", "fornitore", "cliente", "dataInizio"}, method = RequestMethod.POST)
    public ModelAndView addNC(
            @RequestParam("desc") String desc,
            @RequestParam("azioniContenimento") String AC,
            @RequestParam("cause") String cause,
            @RequestParam("gravita") int gravita,
            @RequestParam("tipo") String tipo,
            @RequestParam(value = "reparto", required = false) Integer reparto,
            @RequestParam(value = "fornitore", required = false) String fornitore,
            @RequestParam(value = "cliente", required = false) String cliente,
            @RequestParam("dataInizio") String dataI) {

        ModelAndView model = new ModelAndView();
        Tipo t = ts.findByNome(tipo);
        NonConformita newnc = newnc = new NonConformita(desc, AC, dataI, cause, gravita, t);
        //Apertura di una NC interna
        if (reparto != null) {
            Reparto r = rs.findByID(reparto);
            newnc.setReparto(r);
        } //Apertura di una NC esterna
        else if (cliente != null) {
            Cliente c = cs.findByPiva(cliente);
            newnc.setCliente(c);
        } else if (fornitore != null) {
            Fornitore f = fs.findByPiva(fornitore);
            newnc.setFornitore(f);
        }
        newnc.setDipendente(MainController.getLoggedDip());
        ncs.saveNonConformita(newnc);
        model.addObject("newnc", newnc);
        model.addObject("NCAperte", ncs.findAllAperte());
        model.setViewName("indexCQualita");
        return model;
    }
    
    // metodo modfica nc passare codice nc 
     @RequestMapping(value = {"/editNC"}, method = RequestMethod.GET)
    public String editNC() {
        ModelAndView model = new ModelAndView();
        //codice modifica nc
        model.addObject("NCAperte", ncs.findAllAperte());
        model.addObject("Matricola", MainController.getLoggedDip().getMatricola());
        return "indexCQualita";
    }


    @RequestMapping(value = {"/teamNC"}, method = RequestMethod.GET)
    public ModelAndView teamNC(@RequestParam(value = "codiceNC") int codice) {
        ModelAndView model = new ModelAndView();
        //Prendo la NC dal codice
        NonConformita tm = ncs.findByCodice(codice);
        //Passo tutta la lista dei possibili dipendenti associabili al team
        model.addObject("scrollerDip", ds.findAll());
        //Passo la lista dei dipendenti già associati al team
        model.addObject("dipendentiAssociati", tm.getTeam());

        model.addObject("teamOp", "si");
        model.setViewName("indexCQualita");
        return model;
    }

     @RequestMapping(value = {"/newElaborazione"},params={"id"}, method = RequestMethod.GET)
    public String newElaborazione(@RequestParam("id") int id) {
        ModelAndView model = new ModelAndView();
        NonConformita nc=ncs.findByCodice(id);
        model.addObject("apriElaborazione",ds.findAllOperaiReparto(nc.getReparto().getId()));
        model.addObject("ncPassata",id);
        model.addObject("Matricola", MainController.getLoggedDip().getMatricola());
        return "indexCQualita";
    }
    
    
    
    //finire metodo aggiunta Elaborazioni cazzo mollo
    
    @RequestMapping(value = {"/addElaborazione"},params={"desc","dataInizio","dipendente"}, method = RequestMethod.GET)
    public String addElaborazione(@RequestParam("desc") int id) {
        ModelAndView model = new ModelAndView();
        NonConformita nc=ncs.findByCodice(id);
        model.addObject("apriElaborazione",ds.findAllOperaiReparto(nc.getReparto().getId()));
        model.addObject("Matricola", MainController.getLoggedDip().getMatricola());
        return "indexCQualita";
    }

    
    
    @RequestMapping(value = "/segnalazioni", method = RequestMethod.GET)
    public ModelAndView segnalazioni() {
        ModelAndView model = new ModelAndView();
        model.addObject("segnalazioni", ss.findAll());
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = "/dettaglioSegnalazione", params = {"id"}, method = RequestMethod.GET)
    public ModelAndView dettaglioSegnalazione(@RequestParam("id") String id) {
        ModelAndView model = new ModelAndView();
        model.addObject("segnalazione", ss.findByCodice(Integer.parseInt(id)));
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = "/rimuoviSegnalazione", params = {"id"}, method = RequestMethod.GET)
    public ModelAndView rimuoviSegnalazione(@RequestParam("id") String id) {
        ModelAndView model = new ModelAndView();
        ss.deleteSegnalazione(Integer.parseInt(id));
        model.addObject("segnalazioni", ss.findAll());
        model.setViewName("indexCQualita");
        return model;
    }

}
