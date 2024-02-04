package loginSystem.loginSystem.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import loginSystem.loginSystem.model.LoginUser;
import loginSystem.loginSystem.repository.LoginUserRepository;

//import jakarta.validation.Valid;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import com.example.demo.dao.AuthRepo;
//import com.example.demo.dao.BookRepo;
//import com.example.demo.dao.LoginUserRepo;
//import com.example.demo.dao.StudentRepository;
//import com.example.demo.dao.UserRepository;
//import com.example.demo.model.Author;
//import com.example.demo.model.Book;
//import com.example.demo.model.LoginUser;
//import com.example.demo.model.User;
//import com.example.demo.model.address;
//import com.example.demo.model.student;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

@Controller
public class MainController {
	
	@Autowired
	BCryptPasswordEncoder pe;
	
	@Autowired
	LoginUserRepository lur;
	
	@RequestMapping("/home")
	
	public String home() {
		System.out.println("Home page has been called ! , It is not protected with spring security");
		return "Home";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		System.out.println("Contact page has been called ! , It is not protected with spring security");	
		return "Contact";
	}
	
	@GetMapping("/signup" )
	public String signup() {
		System.out.println("signup page get method has been called ! , It is not protected with spring security");
		return "signup";
	}
	
	@PostMapping("/signupuser" )
	public String signupuser(
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		System.out.println(username);
		System.out.println(password);
		
		LoginUser user=new LoginUser();
		user.setUsername(username);
		user.setPassword(pe.encode(password));
		user.setRole("USER");
		
		lur.save(user);
		
		System.out.println("signup page post method has been called ! , It is not protected with spring security");	
		return "success";
	}
	
}

