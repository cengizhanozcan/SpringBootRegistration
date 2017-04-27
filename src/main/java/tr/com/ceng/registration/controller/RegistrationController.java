package tr.com.ceng.registration.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Cengizhan Ozcan
 */
@Controller
public class RegistrationController implements Serializable{

	@RequestMapping("/")
	public String getIndex(){
		return "hello";
	}
	
	
}
