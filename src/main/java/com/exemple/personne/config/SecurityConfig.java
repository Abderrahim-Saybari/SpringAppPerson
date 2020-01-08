package com.exemple.personne.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider AuthProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		return provider;  
	}

	/** we use this method if we want to use our provided login without fetching it from database  */
	//	@Bean
	//	@Override
	//	protected UserDetailsService userDetailsService() {
	//		
	//		List<UserDetails> users = new ArrayList<>();
	//		users.add(User.withDefaultPasswordEncoder().username("abdo").password("1234").roles("USER").build());
	//
	//		return new InMemoryUserDetailsManager(users);
	//	}
	
	//	@Autowired
	//	private MyUserDetailsService userDetailsService;
	//
	//	@Override
	//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//
	//		DaoAuthenticationProvider authoProvider = new DaoAuthenticationProvider();
	//
	//		authoProvider.setUserDetailsService(userDetailsService);
	//		authoProvider.setPasswordEncoder(new BCryptPasswordEncoder());
	//
	//		auth.authenticationProvider(authoProvider);
	//	}
	//
	//	@Override
	//	protected void configure(HttpSecurity http) throws Exception {
	//		http.authorizeRequests()
	//		.antMatchers("/login").permitAll()
	//		.antMatchers("/personnes").hasRole("ADMIN")
	//		.antMatchers("/users").hasRole("ADMIN")
	//		.and().formLogin()
	//		.and().logout().permitAll().logoutUrl("/logout").logoutSuccessUrl("/");
	//	}
	//
	//	@Bean
	//	PasswordEncoder encoder() {
	//		return new BCryptPasswordEncoder(); 
	//	}

}
