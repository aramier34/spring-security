package fr.iocean.species.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/rest/admin").hasRole("ADMIN").antMatchers("/rest/**").hasRole("USER")
				.anyRequest().authenticated().and().httpBasic();
		return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withUsername("user")
				.password("user123")
				.roles("USER")
				.build();
		UserDetails userAdmin= User.withUsername("admin")
				.password("admin456")
				.roles("ADMIN", "USER")
				.build();
		return new InMemoryUserDetailsManager(user, userAdmin);
		}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		}
	
	
}
