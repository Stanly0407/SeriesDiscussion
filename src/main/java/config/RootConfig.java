package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@EnableWebSecurity
@ComponentScan(basePackages = {"config", "controller", "repository", "model", "service"})
public class RootConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    String encoded = new BCryptPasswordEncoder().encode("admin@123");

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER").and().anonymous()
                .and()
                .authorizeRequests().antMatchers("/userPages/registration").not().fullyAuthenticated()
                .and()
                .authorizeRequests().antMatchers("/*", "/userPages/**").permitAll()
                .antMatchers("/adminPages/**").hasRole("ADMIN")
                .and()
                .authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/loginAction").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login").permitAll()
                .deleteCookies("JSESSIONID")
                .and()
                .csrf().disable();

//        http.sessionManagement()
//              .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)   //сеанс будет создан только при необходимости (по умолчанию ).
//              .invalidSessionUrl("/userPages/homePage")
//              .maximumSessions(2)
//              .expiredUrl("/userPages/homePage");
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}



//    @Bean // для того, чтобы убедиться, что реестр сеансов Spring Security уведомляется об уничтожении сеанса .
//    public HttpSessionEventPublisher httpSessionEventPublisher() {
//        return new HttpSessionEventPublisher(); }
