package nc.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import nc.model.Cliente;
import nc.model.Dipendente;
import nc.model.Elaborazione;
import nc.model.Fornitore;
import nc.model.NonConformita;
import nc.model.Pezzo;
import nc.model.Reparto;
import nc.model.Tipo;
import nc.model.User;
import nc.service.ClienteService;
import nc.service.DipendenteService;
import nc.service.ElaborazioneService;
import nc.service.FornitoreService;
import nc.service.NonConformitaService;
import nc.service.PezzoService;
import nc.service.RepartoService;
import nc.service.SegnalazioneService;
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
@RequestMapping("/cq**")
@ComponentScan("nc.dao")
public class CQualitaController {

    @Autowired
    private PezzoService ps;

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

    @Autowired
    private ElaborazioneService es;

    @Autowired
    private UserService us;

    //ncaperte chiuse elaborazione
    @RequestMapping(value = {"/index", ""}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        List<NonConformita> nc = ncs.findAllAperte();
        model.addObject("NCAperte", nc);
        model.addObject("Matricola", MainController.getLoggedDip().getMatricola());
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/NCElaborazione"}, method = RequestMethod.GET)
    public ModelAndView NCElaborazione() {
        ModelAndView model = new ModelAndView();
        List<NonConformita> nc = ncs.findAllInElaborazione();
        model.addObject("NCElaborazione", nc);
        model.addObject("Matricola", MainController.getLoggedDip().getMatricola());
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/NCChiuse"}, method = RequestMethod.GET)
    public ModelAndView NCChiuse() {
        ModelAndView model = new ModelAndView();
        List<NonConformita> nc = ncs.findAllChiuse();
        model.addObject("NCChiuse", nc);
        model.addObject("Matricola", MainController.getLoggedDip().getMatricola());
        model.setViewName("indexCQualita");
        return model;
    }

    //aggiunta nc
    @RequestMapping(value = {"/apriNC"}, method = RequestMethod.GET)
    public ModelAndView apriNC() {
        ModelAndView model = new ModelAndView();
        model.addObject("Tipi", ts.findAll());
        model.addObject("Reparti", rs.findAll());
        model.addObject("Fornitori", fs.findAll());
        model.addObject("Clienti", cs.findAll());
        model.addObject("NC", true);
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/apriNC"}, params = {"desc"}, method = RequestMethod.GET)
    public ModelAndView apriNCconDescrizione(@RequestParam(value = "desc", required = false) String descrizione) {
        ModelAndView model = new ModelAndView();
        model.addObject("Tipi", ts.findAll());
        model.addObject("Reparti", rs.findAll());
        model.addObject("Fornitori", fs.findAll());
        model.addObject("Clienti", cs.findAll());
        model.addObject("Descrizione", descrizione);
        model.addObject("NC", true);
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/addNC"}, params = {"pezzi", "desc", "azioniContenimento", "cause", "gravita", "tipo", "reparto", "fornitore", "cliente", "dataInizio"}, method = RequestMethod.POST)
    public ModelAndView addNC(
            @RequestParam("pezzi") String pezzi,
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
        NonConformita newnc = new NonConformita(desc, AC, dataI, cause, gravita, t);
        //elaborazione pezzi da associare alla NC
        Set<Pezzo> pezziCorrelati = new HashSet<>();
        pezzi = pezzi.trim();
        String[] parti = pezzi.split(",");
        for (int i = 0; i < parti.length; i++) {
            String[] parti2 = parti[i].split(":");
            switch (parti2.length) {
                case 2:
                    for (int j = Integer.parseInt(parti2[0]); j <= Integer.parseInt(parti2[1]); j++) {
                        pezziCorrelati.add(ps.findByCodice(j));
                    }
                    break;
                case 1:
                    pezziCorrelati.add(ps.findByCodice(Integer.parseInt(parti2[0])));
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        //fine elaborazione
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
        for (Pezzo tmp : pezziCorrelati) {
            Set<NonConformita> nc = tmp.getPezziNC();
            nc.add(newnc);
            tmp.setPezziNC(nc);
            ps.updatePezzo(tmp);
        }
        model.addObject("newnc", newnc);
        model.addObject("NCAperte", ncs.findAllAperte());
        model.setViewName("indexCQualita");
        return model;
    }

    //  modifica nc 
    @RequestMapping(value = {"/editNC"}, params = {"id", "desc", "azioniContenitive",}, method = RequestMethod.GET)
    public ModelAndView editNC(@RequestParam("id") int id, @RequestParam("desc") String desc, @RequestParam("azioniContenitive") String AC) {
        ModelAndView model = new ModelAndView();
        NonConformita nc = ncs.findByCodice(id);
        model.addObject("editNC", nc);
        model.addObject("desc", desc);
        model.addObject("azioniContenitive", AC);
        model.addObject("Matricola", MainController.getLoggedDip().getMatricola());
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/modNC"}, params = {"codNC", "desc", "azioniContenimento", "azioniCorrettive", "azioniPreventive", "dataF", "costo"}, method = RequestMethod.POST)
    public ModelAndView modNC(@RequestParam("codNC") int id,
            @RequestParam("desc") String desc,
            @RequestParam(value = "azioniContenimento", required = false) String Acon,
            @RequestParam(value = "azioniCorrettive", required = false) String Acor,
            @RequestParam(value = "azioniPreventive", required = false) String Aprev,
            @RequestParam(value = "dataF", required = false) String dataF,
            @RequestParam(value = "costo", required = false) Double costo) {
        ModelAndView model = new ModelAndView();
        NonConformita nc = ncs.findByCodice(id);
        nc.setDescrizione(desc);
        if (!Acon.isEmpty()) {
            nc.setAzioniContenimento(Acon);
        }
        if (!Acor.isEmpty()) {
            nc.setAzioniCorrettive(Acor);
        }
        if (!Aprev.isEmpty()) {
            nc.setAzioniPreventive(Aprev);
        }
        if (!dataF.isEmpty()) {
            nc.setDataChiusura(dataF);
        }
        Double c = costo;
        if (c != null && (!c.isNaN())) {
            nc.setCosto(costo);
        }
        ncs.updateNonConformita(nc);
        model.addObject("NCElaborazione", ncs.findAllInElaborazione());
        model.addObject("Matricola", MainController.getLoggedDip().getMatricola());
        model.addObject("ruolo", MainController.getLoggedDip().getUser().getUserRole().iterator().next().getRole());
        model.setViewName("/redirect");
        return model;
    }

    //metodo per vedere nc 
    @RequestMapping(value = {"/visualizzaNC"}, params = {"id"}, method = RequestMethod.GET)
    public ModelAndView visualizzaNC(@RequestParam("id") int id) {
        ModelAndView model = new ModelAndView();
        model.addObject("NCChiesta", ncs.findByCodice(id));
        model.setViewName("indexCQualita");
        return model;
    }

    //elaborazioni
    @RequestMapping(value = {"/newElaborazione"}, params = {"id"}, method = RequestMethod.GET)
    public ModelAndView newElaborazione(@RequestParam("id") int id) {
        ModelAndView model = new ModelAndView();
        NonConformita nc = ncs.findByCodice(id);
        List<Dipendente> l = ds.findAllOperaiReparto(nc.getReparto().getId());
        if (l.isEmpty()) {
            model.addObject("vuoto", "non ci sono operai nel reparto");
        } else {
            model.addObject("apriElaborazione", l);
        }
        model.addObject("ncPassata", id);
        model.addObject("Matricola", MainController.getLoggedDip().getMatricola());
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/addElaborazione"}, params = {"desc", "dataInizio", "codNC", "dipendente"}, method = RequestMethod.POST)
    public ModelAndView addElaborazione(@RequestParam("desc") String desc, @RequestParam("dataInizio") String dataI, @RequestParam("codNC") int id, @RequestParam("dipendente") int matr) {
        ModelAndView model = new ModelAndView();
        Dipendente dip = ds.findByMatricola(matr);
        NonConformita nc = ncs.findByCodice(id);
        es.saveElaborazione(new Elaborazione(desc, dataI, dip, nc));
        model.addObject("NCElaborazione", ncs.findAllInElaborazione());
        model.addObject("Matricola", MainController.getLoggedDip().getMatricola());
        model.setViewName("indexCQualita");
        return model;
    }

    //segnalazioni
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

    @RequestMapping(value = {"/aggiungiTipoNC"}, method = RequestMethod.GET)
    public ModelAndView aggiungiTipoNC() {
        ModelAndView model = new ModelAndView();
        model.addObject("aggiungiTipo", true);
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/addTipo"}, params = {"nome", "descrizione"}, method = RequestMethod.POST)
    public ModelAndView addTipoNC(@RequestParam("nome") String nome, @RequestParam("descrizione") String descrizione) {
        ModelAndView model = new ModelAndView();
        Tipo nt = new Tipo(nome, descrizione);
        ts.saveTipo(nt);
        model.addObject("ruolo", MainController.getLoggedDip().getUser().getUserRole().iterator().next().getRole());
        model.setViewName("/redirect");
        return model;
    }

//teamop
    @RequestMapping(value = {"/showTeam"}, params = {"codice"}, method = RequestMethod.GET)
    public ModelAndView showTeam(@RequestParam("codice") Integer cod) {
        ModelAndView model = new ModelAndView();
        NonConformita nc = ncs.findByCodice(cod);
        Set<Dipendente> dipU = nc.getTeam();
        model.addObject("tco", dipU);
        model.addObject("showTeam", true);
        model.addObject("NCtm", cod);

        if (!dipU.isEmpty()) {
            model.addObject("Dipendenti", ds.findAllLiberi(cod));
        } else {
            model.addObject("Dipendenti", ds.findAllSenzaManager());
        }
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/addOperaioTeamNC"}, params = {"dipendente", "codice"}, method = RequestMethod.POST)
    public ModelAndView addOperaioTeamNC(@RequestParam("dipendente") Integer mat, @RequestParam("codice") Integer cod) {
        ModelAndView model = new ModelAndView();
        Dipendente dip = ds.findByMatricola(mat);
        NonConformita nc = ncs.findByCodice(cod);
        Set<NonConformita> lnc = dip.getParteTeam();
        lnc.add(nc);
        dip.setParteTeam(lnc);
        ds.updateDipendente(dip);
        model.addObject("NCElaborazione", ncs.findAllInElaborazione());
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/eliminaDipTeamOp"}, params = {"dip", "codice"}, method = RequestMethod.GET)
    public ModelAndView showTeam(@RequestParam("dip") Integer mat, @RequestParam("codice") Integer cod) {
        ModelAndView model = new ModelAndView();
        Dipendente dip = ds.findByMatricola(mat);
        NonConformita nc = ncs.findByCodice(cod);

        Set<NonConformita> lnc = dip.getParteTeam();
        for (NonConformita n : lnc) {
            if (n.getCodice() == cod) {
                lnc.remove(n);
            }
        }
        dip.setParteTeam(lnc);
        ds.updateDipendente(dip);
        model.addObject("NCElaborazione", ncs.findAllInElaborazione());
        model.setViewName("indexCQualita");
        return model;
    }

    @RequestMapping(value = {"/pezziNC"}, params = {"ncc"}, method = RequestMethod.GET)
    public ModelAndView showTeam(@RequestParam("ncc") int cod) {
        ModelAndView model = new ModelAndView();
        NonConformita nc = ncs.findByCodice(cod);
        model.addObject("codNc", cod);
        model.addObject("visualPezzi", nc.getPezziCorrelati());
        model.setViewName("indexCQualita");
        return model;
    }
}
