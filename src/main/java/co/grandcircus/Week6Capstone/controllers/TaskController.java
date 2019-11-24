package co.grandcircus.Week6Capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Week6Capstone.models.Task;
import co.grandcircus.Week6Capstone.models.User;
import co.grandcircus.Week6Capstone.repos.TaskRepo;
import co.grandcircus.Week6Capstone.repos.UserRepo;

@Controller
public class TaskController {

	@Autowired
	UserRepo ur;

	@Autowired
	TaskRepo tr;

	@PostMapping("/add-task")
	public ModelAndView addTask(Task t, Integer userid) {
		User u = ur.findByUserid(userid);
		t.setUserAssigned(u);
		tr.save(t);
		return new ModelAndView("redirect:/existing-user?userid=" + userid);
	}

	@PostMapping("/search-task")
	public ModelAndView searchTask(Integer userid, String description) {
		User u = ur.findByUserid(userid);
		List<Task> tl = tr.findByUserAssignedUseridAndDescriptionContaining(userid, description);
		if (tl.isEmpty()) {
			ModelAndView mv = new ModelAndView("tasklist-page", "taskList", u.getTaskList());
			mv.addObject("user", u);
			mv.addObject("sortDateUrl", "sort-date-asc");
			mv.addObject("sortCompleteUrl", "sort-complete-asc");
			mv.addObject("emptySearchAlert", "Sorry, your search did not return any results.");
			return mv;
		}
		ModelAndView mv = new ModelAndView("tasklist-page", "taskList", tl);
		mv.addObject("user", u);
		mv.addObject("sortDateUrl", "sort-date-asc");
		mv.addObject("sortCompleteUrl", "sort-complete-asc");
		return mv;
	}

	@PostMapping("/update-task")
	public ModelAndView updateTask(Task t, Integer userid) {
		User u = ur.findByUserid(userid);
		t.setUserAssigned(u);
		tr.save(t);
		return new ModelAndView("redirect:/existing-user?userid=" + userid);
	}

	@RequestMapping("/delete-task")
	public ModelAndView deleteTask(Integer taskid) {
		Task t = tr.findByTaskid(taskid);
		User u = t.getUserAssigned();
		tr.delete(t);
		return new ModelAndView("redirect:/existing-user?userid=" + u.getUserid());
	}

	@PostMapping("/mark-complete")
	public ModelAndView markComplete(Boolean complete, Integer taskid) {
		Task t = tr.findByTaskid(taskid);
		User u = t.getUserAssigned();
		if (complete == null) {
			complete = false;
		}
		t.setComplete(complete);
		tr.save(t);
		return new ModelAndView("redirect:/existing-user?userid=" + u.getUserid());
	}

	@RequestMapping("/sort-date-asc")
	public ModelAndView sortDateAsc(Integer userid, String sortCompleteUrl) {
		User u = ur.findByUserid(userid);
		ModelAndView mv = new ModelAndView("tasklist-page");
		if (sortCompleteUrl.equals("sort-complete-desc")) {
			mv.addObject("taskList", tr.findByUserAssignedUseridOrderByDueDateAscCompleteAsc(userid));
		} else {
			mv.addObject("taskList", tr.findByUserAssignedUseridOrderByDueDateAscCompleteDesc(userid));
		}
		mv.addObject("user", u);
		mv.addObject("sortDateUrl", "sort-date-desc");
		mv.addObject("sortCompleteUrl", sortCompleteUrl);
		return mv;
	}

	/*
	 * The if else statements in the following methods are there to allow for
	 * multiple sorts at the same time. If the user clicks to sort by date, for
	 * instance, the method will take in the "sortCompleteUrl" which is fed into the
	 * jsp file by the previously called sortByComplete methods to determine how to sort by complete.
	 */

	@RequestMapping("/sort-date-desc")
	public ModelAndView sortDateDesc(Integer userid, String sortCompleteUrl) {
		User u = ur.findByUserid(userid);
		ModelAndView mv = new ModelAndView("tasklist-page");
		if (sortCompleteUrl.equals("sort-complete-desc")) {
			mv.addObject("taskList", tr.findByUserAssignedUseridOrderByDueDateDescCompleteAsc(userid));
		} else {
			mv.addObject("taskList", tr.findByUserAssignedUseridOrderByDueDateDescCompleteDesc(userid));
		}
		mv.addObject("user", u);
		mv.addObject("sortDateUrl", "sort-date-asc");
		mv.addObject("sortCompleteUrl", sortCompleteUrl);
		return mv;
	}

	@RequestMapping("/sort-complete-asc")
	public ModelAndView sortCompleteAsc(Integer userid, String sortDateUrl) {
		User u = ur.findByUserid(userid);
		ModelAndView mv = new ModelAndView("tasklist-page");
		if (sortDateUrl.equals("sort-date-desc")) {
			mv.addObject("taskList", tr.findByUserAssignedUseridOrderByCompleteAscDueDateAsc(userid));
		} else {
			mv.addObject("taskList", tr.findByUserAssignedUseridOrderByCompleteAscDueDateDesc(userid));
		}
		mv.addObject("user", u);
		mv.addObject("sortCompleteUrl", "sort-complete-desc");
		mv.addObject("sortDateUrl", sortDateUrl);
		return mv;
	}

	@RequestMapping("/sort-complete-desc")
	public ModelAndView sortCompleteDesc(Integer userid, String sortDateUrl) {
		User u = ur.findByUserid(userid);
		ModelAndView mv = new ModelAndView("tasklist-page");
		if (sortDateUrl.equals("sort-date-desc")) {
			mv.addObject("taskList", tr.findByUserAssignedUseridOrderByCompleteDescDueDateAsc(userid));
		} else {
			mv.addObject("taskList", tr.findByUserAssignedUseridOrderByCompleteDescDueDateDesc(userid));
		}
		mv.addObject("user", u);
		mv.addObject("sortCompleteUrl", "sort-complete-asc");
		mv.addObject("sortDateUrl", sortDateUrl);
		return mv;
	}
}
