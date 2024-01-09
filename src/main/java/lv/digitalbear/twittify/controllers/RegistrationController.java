package lv.digitalbear.twittify.controllers;

import lv.digitalbear.twittify.domen.Role;
import lv.digitalbear.twittify.domen.User;
import lv.digitalbear.twittify.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}

	@PostMapping("/registration")
	public String addUser(User user, Map<String, String> model) {
		userService.addUser(user);
		return "redirect:/login";
	}
}
