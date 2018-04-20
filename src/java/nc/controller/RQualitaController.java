package nc.controller;

import nc.model.NonConformita;
import nc.service.DipendenteService;
import nc.service.NonConformitaService;
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
@RequestMapping("/rq**")
@ComponentScan("nc.dao")
public class RQualitaController {

    @Autowired
    private TipoService ts;

    @Autowired
    private NonConformitaService ncs;

    @Autowired
    private DipendenteService ds;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();

        model.setViewName("indexRQualita");
        return model;
    }

    /**
     * Dati da prendere dal requestParam Data apertura Tipo Descrizione Piva
     * Fornitore oppure ID reparto oppure PivaCliente (controllo se uno di
     * questi ha un valore valido)
     */
    @RequestMapping(value = {"/addNC"}, method = RequestMethod.GET)
    public ModelAndView addNC() {
        ModelAndView model = new ModelAndView();
        //Creando la NC e precompilando i campi
        NonConformita newnc = new NonConformita();
        newnc.setDipendente(MainController.getLoggedDip());
        model.addObject("newnc", newnc);
        //Passo tutta la lista dei possibili tipi di NC
        model.addObject("scrollerTipo", ts.findAll());
        /**
         * NOME DELLA VIEW PER AGGIUNGERE NUOVE NC
         */
        model.setViewName("");
        return model;
    }

    /**
     * MANCA METODO PER SALVARE LA NC
     */
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
        model.setViewName("");
        return model;
    }

    /**
     * MANCA METODO PER IL TEAM OPERATIVO
     */
}
