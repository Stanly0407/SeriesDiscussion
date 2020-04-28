package config;

//Далее нужно создать класс: WebConfig в который мы добавим ViewResolver
// — пропишем наши суффикс и префикс для вьюшек

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"config", "controller", "repository", "model", "service"})
public class WebConfig implements WebMvcConfigurer {

    @Bean
    ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Register resource handler for CSS and JS
//        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/statics/", "D:/statics/")
//                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

        // Register resource handler for images
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }

}




//    класс  тоже пометили как @Configuration и еще добавили @EnableWebMvc
//    — добавление этой аннотации к классу импортирует
//    конфигурацию Spring MVC из WebMvcConfigurationSupport.
//    Мы также добавили @ComponentScan и прописали наши пакеты.