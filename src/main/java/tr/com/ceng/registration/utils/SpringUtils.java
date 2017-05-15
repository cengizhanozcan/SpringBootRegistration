package tr.com.ceng.registration.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import tr.com.ceng.registration.model.User;

/**
 *
 * @author Cengizhan Ozcan
 */
public class SpringUtils {

	public static User getUser() {
		if (SecurityContextHolder.getContext() != null 
				&& SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null
				&& SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
			return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		}

		return null;
	}
	
	public static Long getUserId(){
		User user = getUser();
		return user == null ? null : user.getId();
	}
}
