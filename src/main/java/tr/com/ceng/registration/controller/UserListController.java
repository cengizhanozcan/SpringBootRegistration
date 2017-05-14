package tr.com.ceng.registration.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.com.ceng.registration.service.UserService;

/**
 *
 * @author Cengizhan Ozcan
 */
@Controller
@RequestMapping("/user")
public class UserListController implements Serializable{

	private static final long serialVersionUID = -6956540165980125131L;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getUserList(Model model){
		model.addAttribute("users", userService.search());
		
		return "user/userList";
	}
	
}
