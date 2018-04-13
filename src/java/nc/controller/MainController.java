package nc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import nc.model.Dipendente;
import nc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public Dipendente loggedDip;

    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security + Hibernate Example");
        model.setViewName("hello");
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
        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request) {
        try {
            request.logout();
        } catch (ServletException ex) {

        }
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
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        ModelAndView model = new ModelAndView();
        // check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);
            model.addObject("username", userDetail.getUsername());
        }
        model.setViewName("403");
        return model;
    }

}
