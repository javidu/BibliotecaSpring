/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONFIGURACIONES;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author JAVIER
 */
@Configuration
@EnableWebMvc
@ComponentScan({"CONTROLADORES", "RESTCONTROLADORES"})
@Import({ContextoAplicacion.class})
public class MvcContext implements WebMvcConfigurer{
    
       
    @Bean
    public InternalResourceViewResolver resolvedor(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/FrontEnd/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
   @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/FrontEnd/**")
                .addResourceLocations("/WEB-INF/FrontEnd/");               
    }
}
