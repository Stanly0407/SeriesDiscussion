package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import service.UserDetailsServiceImp;
//класс для подключения ресурсов

@Configuration   //используется для классов, которые определяют bean-компоненты.
@EnableWebMvc
@EnableWebSecurity //чтобы конфигурация Spring Security была определена любым WebSecurityConfigurer
@ComponentScan(basePackages = {"config", "controller", "repository", "model", "service"})
public class RootConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); }

    String encoded = new BCryptPasswordEncoder().encode("admin@123");

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                          .authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
                .and()
                .authorizeRequests().antMatchers("/userPages**").permitAll()
               .and()
               .authorizeRequests().antMatchers("/adminPages/**").hasRole("ADMIN")
               .and()
               .formLogin().loginPage("/login").loginProcessingUrl("/loginAction").permitAll()
                       .and()
                .logout().logoutSuccessUrl("/login").permitAll()
               .deleteCookies("JSESSIONID")
                .and()
                .csrf().disable();


//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                //сеанс будет создан только при необходимости (по умолчанию ).
//                // Чтобы включить сценарий, который разрешает несколько одновременных сеансов для одного
//                // и того же пользователя, должен использоваться элемент sessionManagement...
//
//                .invalidSessionUrl("/userPages/homePage")
//
//                //Инфраструктура предлагает защиту от типичных атак фиксации сеанса,
//                // настраивая то, что происходит с существующим сеансом, когда пользователь снова пытается аутентифицироваться:
//                // По умолчанию в Spring Security эта защита включена (« migrateSession ») - при аутентификации создается новый HTTP-сеанс, старый считается недействительным, а атрибуты старого сеанса копируются.
//                //  Если это не желаемое поведение, доступны два других варианта.sessionFixation().migrateSession()
//
//                .maximumSessions(2)
//                .expiredUrl("/userPages/homePage");
               }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}


//Первым шагом в включении поддержки одновременного управления сеансом является добавление следующего слушателя.
//Это важно для того, чтобы убедиться, что реестр сеансов Spring Security уведомляется об уничтожении сеанса .
//    @Bean
//    public HttpSessionEventPublisher httpSessionEventPublisher() {
//        return new HttpSessionEventPublisher();
//    }

//    Создаем класс RootConfig который будет унаследован
//    от WebMvcConfigurerAdapter — этот класс имплементирует
//    интерфейс WebMvcConfigurer, которые имеет очень много методов.
//    Из них самые используемые: настройка ресурсов, валидации,
//    сообщений (messaging), интерцепторы (interceptors) и другие.
//    Больше Вы сможете найти в документации. Не забудьте пометить
//    свой класс аннотацией @Configuration