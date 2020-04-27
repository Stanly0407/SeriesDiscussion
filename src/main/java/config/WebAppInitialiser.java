package config;



import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitialiser extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

//Теперь, так как  хотим использовать класс вместо web.xml
// нужно создать WebAppInitialiser
// который  унаследуем от AbstractAnnotationConfigDispatcherServletInitializer.
// В нем есть три метода, которые нужно имплементировать и добавить в них классы настроек