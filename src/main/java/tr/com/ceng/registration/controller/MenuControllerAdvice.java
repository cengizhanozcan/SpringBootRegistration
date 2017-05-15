package tr.com.ceng.registration.controller;

import java.io.Serializable;
import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import tr.com.ceng.registration.model.Role;
import tr.com.ceng.registration.model.User;

/**
 *
 * @author Cengizhan Ozcan
 */
@ControllerAdvice
public class MenuControllerAdvice implements Serializable{

	@ModelAttribute("nameSurname")
	public String getUsername(Authentication authentication){
		User user = getUser(authentication);
		if(user == null){
			return "";
		}
		
		return user.getName() + " " + user.getSurname();
	}

	@ModelAttribute("role")
	public String getRole(Authentication authentication){
		User user = getUser(authentication);
		if(user == null){
			return Role.USER.name();
		}
		
		return user.getRole().name();
	}

	private User getUser(Authentication authentication) {
		if(authentication != null && authentication.getPrincipal() != null 
				&& authentication.getPrincipal() instanceof User){
			return (User) authentication.getPrincipal();
		}
		
		return null;
	}
	
}
