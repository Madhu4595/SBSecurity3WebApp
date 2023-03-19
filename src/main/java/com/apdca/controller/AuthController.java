package com.apdca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apdca.dto.OnlineUsersDto;
import com.apdca.entity.OnlineUsers;
import com.apdca.service.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {

	@Autowired
	private UserService userService;
//	@Autowired
//	private RecaptchaService recaptchaService;

	@GetMapping("/index")
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		// create model object to store form data
		OnlineUsersDto user = new OnlineUsersDto();
		model.addAttribute("user", user);
		return "register";
	}

	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") OnlineUsersDto userDto, BindingResult result, Model model
			) {

	
		OnlineUsers existingUser = userService.findUserByreqloginnm(userDto.getReqloginnm());
		if (existingUser != null && existingUser.getReqloginnm() != null && !existingUser.getReqloginnm().isEmpty()) {
			result.rejectValue("reqloginnm", null, "There is already an account registered with the same email");
		}

		if (result.hasErrors()) {
			model.addAttribute("user", userDto);
			return "/register";
		}

		userService.saveUser(userDto);
		return "redirect:/register?success";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/users")
	public String users() {
		return "users";
	}
	
	@RequestMapping("/403")
	public String accessDenied() {
		System.out.println("in 403");
	    return "/error/403";
	}

}
