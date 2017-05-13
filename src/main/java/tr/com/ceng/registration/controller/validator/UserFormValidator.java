package tr.com.ceng.registration.controller.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import tr.com.ceng.registration.model.User;

/**
 *
 * @author Cengizhan Ozcan
 */
@Component
public class UserFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors error) {
		User user = (User) arg0;
		
		if(StringUtils.isEmpty(user.getUsername())){
			error.rejectValue("username", "user.username.notNull");
		}
		if(StringUtils.isEmpty(user.getName())){
			error.rejectValue("name", "user.name.notNull");
		}
		if(StringUtils.isEmpty(user.getSurname())){
			error.rejectValue("surname", "user.surname.notNull");
		}
		if(StringUtils.isEmpty(user.getPassword())){
			error.rejectValue("password", "user.password.notNull");
		}
		if(StringUtils.isEmpty(user.getConfirmPassword())){
			error.rejectValue("confirmPassword", "user.confirmPassword.notNull");
		}
		if(!user.getPassword().equals(user.getConfirmPassword())){
			error.rejectValue("password", "user.password.notMatch");
		}
		if(StringUtils.isEmpty(user.getEmail())){
			error.rejectValue("email", "user.email.notNull");
		}
		if(user.getRole() == null){
			error.rejectValue("role", "user.role.notNull");
		}
		if(user.getGender() == null){
			error.rejectValue("gender", "user.gender.notNull");
		}
	}

}
