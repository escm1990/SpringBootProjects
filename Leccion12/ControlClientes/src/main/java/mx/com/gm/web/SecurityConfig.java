package mx.com.gm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity //Habilitando seguridad web
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService; //interfaz usada por SpringSecurity para recuperar el objeto user
    
    @Bean
    // Definiendo que Spring use la encriptación
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    //Spring buscará una implementación del objeto AuthenticationManagerBuilder
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    /*Restringir las URL en la aplicación
    -- AUTORIZACION -- */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*antMatchers indica las URL, la sintaxis ** indica que las sub-path
        también están restringidas. hasRole indica los roles que podrán acceder
        a los URL definidos en antMarchers. Además se setea la página de login
        y página de error*/
        http.authorizeRequests()
                .antMatchers("/editar/**", "/agregar/**", "/eliminar").hasRole("ADMIN")
                .antMatchers("/").hasAnyRole("USER", "ADMIN")
                .and().formLogin().loginPage("/login")
                .and().exceptionHandling().accessDeniedPage("/errores/403");
    }

}
