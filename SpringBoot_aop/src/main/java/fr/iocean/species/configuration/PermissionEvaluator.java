package fr.iocean.species.configuration;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class PermissionEvaluator {
	public boolean isIdOkay(Integer id) {
		return id == 1;
		}
	
	@GetMapping("johndoe")
	@PreAuthorize("principal.username == 'johndoe'")
	public String johnDoeOnly() {
		return "Bonjour, John Doe !";
		}

}
