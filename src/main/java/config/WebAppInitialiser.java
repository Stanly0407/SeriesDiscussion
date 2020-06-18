package config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitialiser extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class, WebConfig.class};
        }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    @Override //без этого фильтра в БД сохраняется из представления данные на русском языке странными неопределенными символами
    protected CharacterEncodingFilter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new CharacterEncodingFilter[] { characterEncodingFilter};
    }

}



//чтобы использовать класс вместо web.xml нужно создать WebAppInitialiser кот.  унаслед. от AbstractAnnotationConfigDispatcherServletInitializer.
