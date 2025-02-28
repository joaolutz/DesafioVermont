package br.com.joaolutz.desafiovermont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class DesafioVermontSecurityAdapter extends WebSecurityConfigurerAdapter {
	 
	    @Autowired
	    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
	    
	    @Value("${apiUser}")
	    private String apiUser;
	    
	    @Value("${apiUserPassword}")
	    private String apiUserPassword;
	 
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	          .withUser(apiUser).password(passwordEncoder().encode(apiUserPassword))
	          .authorities("ROLE_USER");
	    }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().authorizeRequests()
	          .antMatchers("/securityNone").permitAll()
	          .anyRequest().authenticated()
	          .and()
	          .httpBasic()
	          .authenticationEntryPoint(authenticationEntryPoint);
	 
	        http.addFilterAfter(new CustomFilter(),
	          BasicAuthenticationFilter.class);
	    }
	 
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	
}
