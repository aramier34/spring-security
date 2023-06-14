package fr.iocean.species.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig{
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String trucAdmin() {return "Personnes administrées.";}
	
	@PreAuthorize("@permissionEvaluator.isIdOkay(#id")
	@GetMapping("/admin")
	public String trucAdminAvecId(@RequestParam Integer id) {
		return "Id administrée.";
		}
	
	
}
