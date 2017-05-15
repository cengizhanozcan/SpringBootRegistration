package tr.com.ceng.registration.controller;

import java.io.Serializable;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.com.ceng.registration.controller.validator.UserFormValidator;
import tr.com.ceng.registration.model.DisplayOption;
import tr.com.ceng.registration.model.Role;
import tr.com.ceng.registration.model.User;
import tr.com.ceng.registration.service.UserService;
import tr.com.ceng.registration.utils.SpringUtils;

/**
 *
 * @author Cengizhan Ozcan
 */
@Controller
@RequestMapping("/user")
public class UserFormController implements Serializable{

	private static final long serialVersionUID = 44553529848120954L;

	@Autowired
	private UserFormValidator userFormValidator;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getUserForm(Model model){
		User user = new User();
		model.addAttribute("user", user);
		
		return "user/userForm";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String postUserForm(@ModelAttribute User user, BindingResult bindingResult){
		userFormValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors()){
			return "user/userForm";
		}
		
		userService.save(user);
		return "redirect:/user/create/" + user.getId() + "/" + DisplayOption.VIEW;
	}
	
	@RequestMapping(value = "/create/{id}/{displayOption}", method = RequestMethod.GET)
	public String getUserForm(@PathVariable(value = "id", required = false) Long id, @PathVariable("displayOption") 
			DisplayOption displayOption, Model model){
		User currentUser = SpringUtils.getUser();
		if(currentUser.getRole() != Role.ADMIN){
			if(!currentUser.getId().equals(id)){
				return "403";
			}
		}
		User user = userService.findById(id);
		model.addAttribute("user", user);
		if(displayOption == DisplayOption.VIEW){
			model.addAttribute("readonly", true);
		} else {
			model.addAttribute("readonly", false);
		}
		
		return "user/userForm";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String postDeleteUser(@PathVariable(value = "id") Long id){
		User currentUser = SpringUtils.getUser();
		if(currentUser.getRole() != Role.ADMIN){
			return "403";
		}
		User user = userService.findById(id);
		userService.delete(user);
		
		return "redirect:/user";
	}
	
}
