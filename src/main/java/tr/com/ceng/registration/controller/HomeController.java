package tr.com.ceng.registration.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.com.ceng.registration.model.DisplayOption;
import tr.com.ceng.registration.utils.SpringUtils;

/**
 *
 * @author Cengizhan Ozcan
 */
@Controller
public class HomeController implements Serializable{

	@RequestMapping("/")
	public String getIndex(){
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(){
		return "home";
	}
	
	@RequestMapping(value = "/home/redirectUserEdit")
	public String getUserEditPage() {
		return "redirect:/user/create/" + SpringUtils.getUserId() + "/" + DisplayOption.EDIT;
	}
}
