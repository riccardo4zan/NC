package nc.controller;

import java.util.Date;
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
import nc.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cq**")
@ComponentScan("nc.dao")
public class CQualitaController {

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
    public String index(ModelMap model) {
        return "indexCQualita";
    }

    /**
     * Dati da prendere dal requestParam Data apertura Tipo Descrizione Piva
     * Fornitore oppure ID reparto oppure PivaCliente (controllo se uno di
     * questi ha un valore valido)
     */
    @RequestMapping(value = {"/NCInterna"}, method = RequestMethod.GET)
    public ModelAndView NCInterna() {
        ModelAndView model = new ModelAndView();
        //Passo tutta la lista dei possibili tipi di NC
        model.addObject("Tipi", ts.findAll());
        model.addObject("Reparti", rs.findAll());
        /**
         * NOME DELLA VIEW PER AGGIUNGERE NUOVE NC
         */
        model.addObject("addNCInterna", "si");
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/NCEsterna"}, method = RequestMethod.GET)
    public ModelAndView NCEsterna() {
        ModelAndView model = new ModelAndView();
        //Passo tutta la lista dei possibili tipi di NC
        model.addObject("Tipi", ts.findAll());
        model.addObject("Fornitori", fs.findAll());
        model.addObject("Clienti", cs.findAll());
        /**
         * NOME DELLA VIEW PER AGGIUNGERE NUOVE NC
         */
        model.addObject("addNCEsterna", "si");
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/addNCInterna"}, params = {"desc", "tipo", "reparto", "dataInizio"}, method = RequestMethod.GET)
    public ModelAndView addNCInterna(@RequestParam("desc") String desc, @RequestParam("tipo") Tipo tipo, @RequestParam("reparto") Reparto reparto, @RequestParam("dataInizio") Date dataI) {
        ModelAndView model = new ModelAndView();
        //Creando la NC e precompilando i campi
        NonConformita newnc = new NonConformita(desc, (java.sql.Date) dataI, tipo, reparto);
        newnc.setDipendente(MainController.getLoggedDip());
        ncs.saveNonConformita(newnc);
        model.addObject("newnc", newnc);
        /**
         * NOME DELLA VIEW PER AGGIUNGERE NUOVE NC
         */

        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/addNCEsterna"}, params = {"desc", "tipo", "fornitore", "cliente", "dataInizio"}, method = RequestMethod.GET)
    public ModelAndView addNCEsterna(@RequestParam("desc") String desc, @RequestParam("tipo") Tipo tipo, @RequestParam("fornitore") Fornitore fornitore, @RequestParam("cliente") Cliente cliente, @RequestParam("dataInizio") Date dataI) {
        ModelAndView model = new ModelAndView();
        //Creando la NC e precompilando i campi
        if (fornitore == null) {
            NonConformita newnc = new NonConformita(desc, (java.sql.Date) dataI, tipo, cliente);
            newnc.setDipendente(MainController.getLoggedDip());
            model.addObject("newnc", newnc);

            model.addObject("addNCEsterna", "si");
            model.setViewName("indexCQualita");
            return model;
        }
        NonConformita newnc = new NonConformita(desc, (java.sql.Date) dataI, tipo, fornitore);
        newnc.setDipendente(MainController.getLoggedDip());
        model.addObject("newnc", newnc);

        model.addObject("addNCEsterna", "si");
        model.setViewName("indexCQualita");
        return model;
    }

    /**
     * Passami il codice della NonConformità attraverso il GET o il post
     *
     * Bottone accanto al nome della NC nella lista che se cliccato manda alla
     * pagina di gestione del team delle NC
     *
     * @return
     */
    @RequestMapping(value = {"/teamNC"}, method = RequestMethod.GET)
    public ModelAndView teamNC(@RequestParam(value = "codiceNC") int codice) {
        ModelAndView model = new ModelAndView();
        //Prendo la NC dal codice
        NonConformita tm = ncs.findByCodice(codice);
        //Passo tutta la lista dei possibili dipendenti associabili al team
        model.addObject("scrollerDip", ds.findAll());
        //Passo la lista dei dipendenti già associati al team
        model.addObject("dipendentiAssociati", tm.getTeam());

        /**
         * NOME DELLA VIEW PER AGGIUNGERE AL TEAM
         */
        model.addObject("teamOp", "si");
        model.setViewName("indexCQualita");
        return model;
    }

    /**
     * MANCA METODO PER IL TEAM OPERATIVO
     */
}
