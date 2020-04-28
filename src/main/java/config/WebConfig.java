package config;

//Далее нужно создать класс: WebConfig в который мы добавим ViewResolver
// — пропишем наши суффикс и префикс для вьюшек

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"config", "controllers", "dao", "model", "service"})
public class WebConfig {

    @Bean
    ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}




//    класс  тоже пометили как @Configuration и еще добавили @EnableWebMvc
//    — добавление этой аннотации к классу импортирует
//    конфигурацию Spring MVC из WebMvcConfigurationSupport.
//    Мы также добавили @ComponentScan и прописали наши пакеты.