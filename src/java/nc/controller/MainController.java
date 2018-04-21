package nc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nc.model.Dipendente;
import nc.model.User;
import nc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private UserService us;
    
    /**
     * Oggetto relativo al dipendente che ha effettuato il login
     */
    private static Dipendente loggedDip;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)  
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null) new SecurityContextLogoutHandler().logout(request, response, auth);
        model.setViewName("login");
        return model;
    }
    
    @RequestMapping(value = "/showChangePsswd", method = RequestMethod.POST)  
    public ModelAndView showChangePassword() {
        ModelAndView model = new ModelAndView();
        model.setViewName("changePassword");
        return model;
    }

    @RequestMapping(value = "/ChangePsswd", params={"psswd"}, method = RequestMethod.POST)  
    public ModelAndView showChangePassword(@RequestParam("psswd")String password) {
        ModelAndView model = new ModelAndView();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String hashedPassword = passwordEncoder.encode(password);
        //Cambio della password dell'user associato al dipendente associato
        User usr = loggedDip.getUser();
        usr.setPassword(hashedPassword);
        us.updateUser(usr);
        model.addObject("ruolo", loggedDip.getUser().getUserRole().iterator().next().getRole());
        model.setViewName("redirect");
        return model;
    }

    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }
        return error;
    }

    // for 403 access denied page
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public ModelAndView redirection() {
        ModelAndView model = new ModelAndView();
        /**
         * Cerco di recuperare il riferimento all'utente loggato nella richiesta
         * HTTP e di ricavarne il dipendente associato
         */
        try {
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            this.loggedDip = us.findByUserName(user.getUsername()).getDip();
            model.addObject("message", "La matricola del dipendente loggato è:" + this.loggedDip.getMatricola());
        } catch (Exception ex) {
            model.addObject("message", "Problema nel trovare il numero del dipendente");
        }
        // check if user is logged in
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            //passa il ruolo alla pagina redirect
            model.addObject("ruolo", loggedDip.getUser().getUserRole().iterator().next().getRole());
        }
        model.setViewName("redirect");
        return model;
    }
    
    

    public static Dipendente getLoggedDip() {
        return loggedDip;
    }

}
