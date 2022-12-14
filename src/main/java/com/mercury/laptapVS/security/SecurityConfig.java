package com.mercury.laptapVS.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mercury.laptapVS.security.handler.AccessDeniedHandlerImpl;
import com.mercury.laptapVS.security.handler.AuthenticationEntryPointImpl;
import com.mercury.laptapVS.security.handler.AuthenticationFailureHandlerImpl;
import com.mercury.laptapVS.security.handler.AuthenticationSuccessHandlerImpl;
import com.mercury.laptapVS.security.handler.LogoutSuccessHandlerImpl;

@SuppressWarnings("deprecation")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationEntryPointImpl authenticationEntryPointImpl;

	@Autowired
	private AccessDeniedHandlerImpl accessDeniedHandlerImpl;

	@Autowired
	private AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;

	@Autowired
	private AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;

	@Autowired
	private LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;
	
	@Autowired
	private UserDetailsService userDetailsServiceImpl;

	public void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().cors();
		
		
		http.authorizeRequests(
				(requests) -> requests
								.antMatchers(HttpMethod.DELETE, "/orders/*")
									.hasRole("ADMIN")
								.antMatchers(HttpMethod.POST, "/orders")
									.hasAuthority("ROLE_USER")
								.anyRequest()
									.permitAll()
				);
		
		http.exceptionHandling()
			.accessDeniedHandler(accessDeniedHandlerImpl)
			.authenticationEntryPoint(authenticationEntryPointImpl)		// this handler will disable the default login page, no more show
			;
		
		http.formLogin()
		    .permitAll()
			.usernameParameter("username")
			.passwordParameter("password")
			.successHandler(authenticationSuccessHandlerImpl)
			.failureHandler(authenticationFailureHandlerImpl)
		;
		
		http.logout()
			.permitAll()
			.logoutUrl("/logout")
			.logoutSuccessHandler(logoutSuccessHandlerImpl)
			;
		
		http.httpBasic();
	}
	
	@Bean // put the return object into spring container, as a bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}
	
	
  
	//cors support
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://harryhl-bucket.s3-website-us-east-1.amazonaws.com"));
        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedOrigin("http://ec2-54-173-200-24.compute-1.amazonaws.com:8080/"); // You should only set trusted site here. e.g. http://localhost:4200/ means only this site can access.
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","HEAD","OPTIONS"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	
	@Autowired // @Autowired on function will autowired the parameters
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder(11));
	}
	
}
