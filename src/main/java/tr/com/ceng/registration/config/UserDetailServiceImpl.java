package tr.com.ceng.registration.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tr.com.ceng.registration.model.User;
import tr.com.ceng.registration.service.UserService;

/**
 *
 * @author Cengizhan Ozcan
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	@Qualifier(value = "userService")
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		if(user != null){
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
			grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().name()));
			
			return user;
		}
		
		return null;
	}
	
}
