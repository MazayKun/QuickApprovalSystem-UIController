package qas.uicontroller.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.AccessDeniedHandler;
import qas.uicontroller.service.CookieService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenProvider jwtTokenProvider;
    private CookieService cookieService;
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    public SecurityConfig(JwtTokenProvider jwtTokenProvider, CookieService cookieService, CookieService cookieService1, CustomAccessDeniedHandler customAccessDeniedHandler) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.cookieService = cookieService1;
        this.customAccessDeniedHandler = customAccessDeniedHandler;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("admin")
                .anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(customAccessDeniedHandler)
                .and().apply(new JwtConfigurer(jwtTokenProvider, cookieService));
    }
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**" ,"/**/*.js", "/**/*.css", "/**/*.map",
                        "/login", "/reg","/error", "/loggout", "/loginJwtErr");
    }

}
