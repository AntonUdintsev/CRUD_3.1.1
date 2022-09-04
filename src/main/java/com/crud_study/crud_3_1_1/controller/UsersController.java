package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;
import web.service.UserServiceImpl;
import web.model.User;


@Controller
@RequestMapping(value = "/users")
public class UsersController {
	private final UserService userService;


	public UsersController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping()
	public String printWelcome(ModelMap model, @RequestParam(value = "count", required = false) Integer count) {
		model.addAttribute("users", userService.getUsers());
		return "users/users";
	}
	@GetMapping(value = "/new")
	public String newUser (@ModelAttribute("user") User user){
		return "users/form";
	}
	@PostMapping ()
	public  String createUser (@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/users";
	}

	@GetMapping (value = "/{id}")
	public String showUser (@PathVariable ("id") int id, ModelMap model){
		model.addAttribute("user",userService.showUser(id));
		return  "users/showUser";
	}
	@GetMapping (value = "/{id}/edit")
	public String editUser (ModelMap model, @PathVariable ("id") int id) {
		model.addAttribute("user", userService.showUser(id));
		return "users/edit";
	}

	@PatchMapping (value = "/{id}")
	public String updateUser (@ModelAttribute("user") User user, @PathVariable("id") int id){
		userService.updateUser(id,user);
		return "redirect:/users";
	}
	@DeleteMapping (value = "/{id}")
	public String deleteUser (@PathVariable ("id") int id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}

}