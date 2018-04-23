package nc.controller;

import nc.model.NonConformita;
import nc.model.User;
import nc.service.DipendenteService;
import nc.service.NonConformitaService;
import nc.service.TipoService;
import nc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
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

    @Autowired
    private UserService us;

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
    @RequestMapping(value = {"/dati"}, method = RequestMethod.GET)
    public ModelAndView visualizzaDati() {
        ModelAndView model = new ModelAndView();
        model.addObject("datiPersonali", MainController.getLoggedDip());
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/cambiaPassword"}, method = RequestMethod.GET)
    public ModelAndView cambiaPassword() {
        ModelAndView model = new ModelAndView();
        //Passo un valore true per permettere l'inclusione del frammento di codice relativo al cambio della password
        model.addObject("changePassword", true);
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/saveNewPasswd"}, params = {"psswd1"}, method = RequestMethod.POST)
    public ModelAndView savePassword(@RequestParam("psswd1") String psswd) {
        ModelAndView model = new ModelAndView();
        //Controllo e cambio della password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hpsswd = passwordEncoder.encode(psswd);
        User u = MainController.getLoggedDip().getUser();
        u.setPassword(hpsswd);
        us.updateUser(u);
        model.addObject("ruolo", MainController.getLoggedDip().getUser().getUserRole().iterator().next().getRole());
        model.setViewName("/redirect");
        return model;
    }
}
