package nc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //SETTANDO I PERMESSI PER I VARI RUOLI
                .antMatchers("/ma**").access("hasRole('ROLE_MANAGER')")
                .antMatchers("/cq**").access("hasRole('ROLE_CONTROLQUA')")
                .antMatchers("/rq**").access("hasRole('ROLE_RESPOQUA')")
                .antMatchers("/op**").access("hasRole('ROLE_OPERAIO')")
                .and()
                    .formLogin()
                    .loginPage("/")
                    .permitAll()
                    .failureUrl("/")
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and()
                    .logout().logoutSuccessUrl("/")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/redirect");
        http.formLogin().defaultSuccessUrl("/redirect", true);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}