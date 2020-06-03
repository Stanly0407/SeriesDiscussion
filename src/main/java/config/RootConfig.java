package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import service.UserDetailsServiceSec;
//класс для подключения ресурсов

@Configuration   //используется для классов, которые определяют bean-компоненты.
@EnableWebSecurity
@ComponentScan(basePackages = {"config", "controller", "repository", "model", "service"})
public class RootConfig extends WebSecurityConfigurerAdapter {

    @Autowired(required = true)
    private UserDetailsServiceSec userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }
//    вариант1
//    @Override
//    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }

//
//    Вариант 2
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider
//                = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(encoder());
//        return authProvider;
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
//                .and()
//                .authorizeRequests().antMatchers("/login**").permitAll()
//                .and()
//                .formLogin().loginPage("/login").loginProcessingUrl("/loginAction").permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/login").permitAll()
//                .and()
//                .csrf().disable();
//    }
//}


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/adminPages/**").hasRole("ADMIN")
                .antMatchers("/userPages/homePage").anonymous()
                .antMatchers("/userPages/authentication", "/userPages/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/userPages/authentication").loginProcessingUrl("authentication").permitAll()
                .defaultSuccessUrl("/userPages/homePageSuccessfully", true)
                // .failureUrl("/authentication.jsp?error=true").failureHandler(authenticationFailureHandler())
                .and()
                .logout().logoutSuccessUrl("/userPages/homePage").permitAll()
                .deleteCookies("JSESSIONID");
        //   .logoutSuccessHandler(logoutSuccessHandler())

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                //сеанс будет создан только при необходимости (по умолчанию ).
                // Чтобы включить сценарий, который разрешает несколько одновременных сеансов для одного
                // и того же пользователя, в конфигурации XML должен использоваться элемент <session-management> :

                .invalidSessionUrl("/userPages/homePage")

                //Инфраструктура предлагает защиту от типичных атак фиксации сеанса,
                // настраивая то, что происходит с существующим сеансом, когда пользователь снова пытается аутентифицироваться:
//        По умолчанию в Spring Security эта защита включена (« migrateSession ») - при аутентификации создается новый HTTP-сеанс,
//        старый считается недействительным, а атрибуты старого сеанса копируются.
//        Если это не желаемое поведение, доступны два других варианта
                .sessionFixation().migrateSession()

                .maximumSessions(2)
                .expiredUrl("/userPages/homePage")

        ;
    }


    //Первым шагом в включении поддержки одновременного управления сеансом является добавление следующего слушателя.
    //Это важно для того, чтобы убедиться, что реестр сеансов Spring Security уведомляется об уничтожении сеанса .
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }


}


//    Для страниц, которые никак не обрабатываются сервером, а просто возвращают страницу, маппинг можно настроить в конфигурации. Страница login обрабатывается Spring Security контроллером по умолчанию, поэтому для неё отдельный контроллер не требуется.
//
//    @Configuration
//    public class MvcConfig implements WebMvcConfigurer {
//
//        @Override
//        public void addViewControllers(ViewControllerRegistry registry) {
//            registry.addViewController("/login").setViewName("login");
//            registry.addViewController("/news").setViewName("news");
//        }
//    }


//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                //Доступ только для не зарегистрированных пользователей
//                .antMatchers("/registration").not().fullyAuthenticated()
//                //Доступ только для пользователей с ролью Администратор
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/news").hasRole("USER")
//                //Доступ разрешен всем пользователей
//                .antMatchers("/", "/resources/**").permitAll()
//                //Все остальные страницы требуют аутентификации
//                .anyRequest().authenticated()
//                .and()
//                //Настройка для входа в систему
//                .formLogin()
//                .loginPage("/login")
//                //Перенарпавление на главную страницу после успешного входа
//                .defaultSuccessUrl("/")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/");
//    }

//    Создаем класс RootConfig который будет унаследован
//    от WebMvcConfigurerAdapter — этот класс имплементирует
//    интерфейс WebMvcConfigurer, которые имеет очень много методов.
//    Из них самые используемые: настройка ресурсов, валидации,
//    сообщений (messaging), интерцепторы (interceptors) и другие.
//    Больше Вы сможете найти в документации. Не забудьте пометить
//    свой класс аннотацией @Configuration