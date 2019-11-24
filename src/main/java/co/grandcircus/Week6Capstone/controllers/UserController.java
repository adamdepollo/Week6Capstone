package co.grandcircus.Week6Capstone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Week6Capstone.models.User;
import co.grandcircus.Week6Capstone.repos.UserRepo;

@Controller
public class UserController {

	@Autowired
	UserRepo ur;

	@PostMapping("/existing-user")
	public ModelAndView existingUserTasklistPage(String email, String password) {
		if (ur.findByEmail(email) == null) {
			return new ModelAndView("index", "badEmailCredential",
					"Sorry, we couldn't find an account using that email. Please try again.");
		}
		if (!password.equals(ur.findByEmail(email).getPassword())) {
			return new ModelAndView("index", "badPassCredential",
					"Sorry, the password you entered was incorrect. Please try again.");
		}
		User u = ur.findByEmailAndPassword(email, password);
		ModelAndView mv = new ModelAndView("tasklist-page", "taskList", u.getTaskList());
		mv.addObject("user", u);
		mv.addObject("sortDateUrl", "sort-date-asc");
		mv.addObject("sortCompleteUrl", "sort-complete-asc");
		return mv;
	}

	@RequestMapping("/existing-user")
	public ModelAndView existingUserRedirect(Integer userid) {
		User u = ur.findByUserid(userid);
		ModelAndView mv = new ModelAndView("tasklist-page", "taskList", u.getTaskList());
		mv.addObject("user", u);
		mv.addObject("sortDateUrl", "sort-date-asc");
		mv.addObject("sortCompleteUrl", "sort-complete-asc");
		return mv;
	}

	@PostMapping("/new-user")
	public ModelAndView newUserTasklistPage(User u) {
		ur.save(u);
		return new ModelAndView("redirect:/existing-user?userid=" + u.getUserid());
	}
}
