package mx.com.gm.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/*La clase debe ser registrada como un bean de configuración*/
@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    /*Crea un objeto LocalResolver. Al mandar a llamar a este método, gracias a 
    la anotación Bean, al llamar el método en automático se agregará el bean a 
    Spring y podremos usarlo como cualquier bean compartido en el contexto de 
    Spring en el contenedor de Spring*/
    @Bean
    public LocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }
    
    /*Definiendo un interceptor*/
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    /*Registrar el interceptor*/
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
}
