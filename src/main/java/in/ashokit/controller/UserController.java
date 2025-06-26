package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.dto.UserDto;
import in.ashokit.service.EmailService;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/")
	public String index(@ModelAttribute("user") UserDto user, Model model) {
		// model.addAttribute("user", new UserDto());
		return "index";
	}

	@PostMapping("/user-submit")
	public String handleSubmit(@Valid @ModelAttribute("user") UserDto user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "index";
		}

		System.out.println(user);

		String subject = "Registration Success";
		String body = "<h1>Welcome to Ashok IT..!<h1> <br/> <h3>Your account got created..</h3>";

		boolean sendEmail = emailService.sendEmail(user.getEmail(), subject, body);
		if (sendEmail) {
			model.addAttribute("msg", "User Form Submitted & Email Sent");
		}
		return "index";
	}
}
