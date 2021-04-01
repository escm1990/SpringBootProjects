package mx.com.gm.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity //Habilitando seguridad web
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*Método para agregar nuevos usuarios (en memoria)
    Esto desactivará el usuario por defecto
    -- AUTENTICACION -- */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*{noop} --> Indica que NO es necesario encriptar el password*/
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}123").roles("ADMIN", "USER")
                .and().withUser("user").password("{noop}123").roles("USER");
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
