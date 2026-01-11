package com.gul.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gul.entity.Student;
import com.gul.repo.StudentRepository;

@Controller
public class HomeController {

	@Autowired
	StudentRepository repo;

//	private Logger logger = Logger.getLogger(HomeController.class);

	@GetMapping("/in")
	public String view() {
//		logger.info("View method called");
		System.out.println("testing");
//		TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
//		String exp = "";
//		CronTrigger trigger = new CronTrigger("test",timeZone);
		return "index";
	}

//	@GetMapping(value = { "/", "add" })
	@GetMapping("add")
	public String home(Model model) {
		System.out.println(repo.listStudent());
		model.addAttribute("student", new Student());
		return "home";
	}

	@PostMapping("save")
	public ModelAndView save(@ModelAttribute("student") Student student) {
		ModelAndView mav = new ModelAndView("home");
		repo.save(student);
		mav.addObject("student", new Student());
		return mav;
	}

	@GetMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("list");
		List<Student> list = repo.findAll();
		mav.addObject("list", list);
		return mav;
	}

	@GetMapping("update")
	public ModelAndView update(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("home");
		Student student = repo.getOne(id);
		mav.addObject("student", student);
		return mav;
	}

	@GetMapping("delete")
	public ModelAndView delete(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("list");
		Student std = repo.getOne(id);
//		 std.setIsDeleted(true);
//		repo.saveAndFlush(std);
		repo.deleteById(id);
		List<Student> list = repo.findAll();
		mav.addObject("list", list);
		return mav;
	}

	@GetMapping("test")
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("student", new Student());
		return mav;
	}

	@GetMapping("thread")
	@ResponseBody
	public String thread() {
		for (int i = 1; i < 50; i++) {
			// the thread will sleep for the 500 milli seconds
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
		System.out.println("Done");
		return "Ok";
	}

}
