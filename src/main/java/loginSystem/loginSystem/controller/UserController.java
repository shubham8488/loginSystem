package loginSystem.loginSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/dashboard")
	public String dashboard() {
		System.out.println("user dashboard page has been called ! , It is  protected with spring security");
		return "dashboard";
	}
	
}
