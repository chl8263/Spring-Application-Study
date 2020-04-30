package me.ewan.security.config;

import com.sun.org.apache.xml.internal.utils.res.XResources_it;
import me.ewan.security.Common.LoggingFilter;
import me.ewan.security.account.AccountService;
import me.ewan.security.account.LoginfailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.persistence.Access;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountService accountService;

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {return new LoginfailureHandler();}

    /*
    * For session out when logout
    * */
    @Bean
    public SessionRegistry sessionRegistry() {return new SessionRegistryImpl(); }

    /*
     * For session out when logout
     * */
    @Bean
    public static ServletListenerRegistrationBean servletListenerRegistrationBean(){return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());}

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManager() throws Exception {return super.authenticationManagerBean(); } 

    public SecurityExpressionHandler expressionHandler(){

        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");

        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setRoleHierarchy(roleHierarchy);

        return handler;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //http.addFilterBefore(new LoggingFilter(), WebAsyncManagerIntegrationFilter.class);

        http.authorizeRequests()
                .mvcMatchers("/", "info", "account/**", "signup").permitAll()
                .mvcMatchers("/admin").hasRole("ADMIN")
                .mvcMatchers("/user").hasRole("USER")
                //.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .anyRequest().authenticated()
                .expressionHandler(expressionHandler())
        ;

        http.formLogin()
                //.usernameParameter("my-username")
                //.passwordParameter("my-password")
                .loginPage("/login").permitAll()
                .failureHandler(authenticationFailureHandler())
        ;

//        http.rememberMe()
//                .rememberMeParameter("remember-me")
//                .userDetailsService(accountService)
//                .key("remember-me-sample");

        http.httpBasic();

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
        ;

        http.sessionManagement()
                .sessionFixation()
                    .changeSessionId()
                    .invalidSessionUrl("/login")
                .maximumSessions(1)
                    .maxSessionsPreventsLogin(true)
        ;

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        ;

        // TODO ExceptionTranslatorFilter -> FilterSecurityInterceptor (AccessDecisionManager)
        // TODO AuthenticationException
        // TODO AccessDeniedException

        http.exceptionHandling()
            .accessDeniedHandler((request, response, accessDeniedException) -> {
                UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                String username = principal.getUsername();
                System.out.println(username + " is denied to access " + request.getRequestURI());
                response.sendRedirect("/access-denied");
            })
        ;

        //SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL); //Share security context, if create new Thread
    }

    // in memory
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("ewan").password("{noop}123").roles("USER").and()
//                .withUser("admin").password("{noop}!@#").roles("ADMIN");
//    }
}