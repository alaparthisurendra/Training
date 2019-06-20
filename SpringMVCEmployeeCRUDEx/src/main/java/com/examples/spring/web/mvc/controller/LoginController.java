package com.examples.spring.web.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.examples.spring.web.mvc.exception.LoginException;
import com.examples.spring.web.mvc.model.Login;

/**
 * Handles requests for the application login page.
 */
@Controller
@SessionAttributes("userName")
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)	
	public ModelAndView login(Model model) {

		return new ModelAndView("login", "command", new Login());
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@ExceptionHandler(LoginException.class)
	public ModelAndView authenticate(@ModelAttribute Login login, Model model, HttpSession session) {
		
		if(login.getUserName().equalsIgnoreCase("admin") && login.getPassword().equalsIgnoreCase("admin@123"))
		{
//			logger.info("Authentication success");
//			session.setAttribute("userName", login.getUserName());
			model.addAttribute("userName", "admin");
			return new ModelAndView("redirect:/employee/list");
		}
		else
		{
//			logger.info("Authentication failed");
			throw new LoginException("Invalid User or Password");
//			return new ModelAndView("redirect:/login");
		}
		
	}
	
	public List<Login> getUsers()
	{
		List<Login> users = new ArrayList<Login>();
		users.add(new Login("admin","admin@123"));
		users.add(new Login("manager", "manager@123"));
		users.add(new Login("user", "user@123"));
	
		return users;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, SessionStatus sessionStatus)
	{		
		sessionStatus.setComplete();
//		session.removeAttribute("userName");		
//		session.invalidate();
		return "redirect:/";
	}
}