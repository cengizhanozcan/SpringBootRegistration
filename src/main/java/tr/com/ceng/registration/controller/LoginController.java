package tr.com.ceng.registration.controller;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Cengizhan Ozcan
 */
@Controller
public class LoginController implements Serializable{

	private static final long serialVersionUID = -3991390734960591830L;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout){
		ModelAndView model = new ModelAndView();
		if(StringUtils.isNotEmpty(error)){
			model.addObject("error", "Gecersiz KullaniciAdi Parola!");
		}
		if(StringUtils.isNotEmpty(logout)){
			model.addObject("message", "Basarili Bir Sekilde Cikis Yapildi.");
		}
		
		return "login";
	}
	
	@RequestMapping("/")
	public String getIndex(){
		return "hello";
	}
	
}
