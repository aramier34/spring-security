package fr.iocean.species.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DomainUserDetailsService implements UserDetailsService {

	@Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		// #1 Aller chercher l’utilisateur par son nom via le Repository
		// #2 Le convertir en UserDetails(Spring Security)}
	}


new org.springframework.security.core.userdetails.User(
		myUser.getLogin(),
		myUser.getPassword(),
		grantedAuthorities// <= liste d’authoritiesà créer aussi
		);

new SimpleGrantedAuthority("nom de l'authority");
}