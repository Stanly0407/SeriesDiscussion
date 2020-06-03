package config;


import com.mysql.cj.Session;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

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

    @Override //без этого фильтра в БД сохраняется из представления данные на русском языке странными неопределенными символами
    protected CharacterEncodingFilter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new CharacterEncodingFilter[] { characterEncodingFilter};
    }

//    @Override
//    public void onStartup(ServletContext sc) throws ServletException {
//        // ... для защиты нашего сеансового куки
//        sc.getSessionCookieConfig().setHttpOnly(true);
//        sc.getSessionCookieConfig().setSecure(true);
//    }
//    @Override
//    protected void registerDispatcherServlet(ServletContext servletContext) {
//        super.registerDispatcherServlet(servletContext);
//        servletContext.addListener(new Session.SessionEventListener() {
//            @Override
//            public void handleNormalClose() {
//
//            }
//
//            @Override
//            public void handleReconnect() {
//
//            }
//
//            @Override
//            public void handleCleanup(Throwable throwable) {
//
//            }
//        });}


}

//Теперь, так как  хотим использовать класс вместо web.xml
// нужно создать WebAppInitialiser
// который  унаследуем от AbstractAnnotationConfigDispatcherServletInitializer.
// В нем есть три метода, которые нужно имплементировать и добавить в них классы настроек