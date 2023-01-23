package com.spring.springApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@PostMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String name, 
			@RequestParam String surname,
			@RequestParam String departmentName) {
		
		Department department =  departmentRepository.findByDepartmentName(departmentName);
		User n = new User();
		n.setName(name);
		n.setSurname(surname);
		n.setDepartment(department);
		userRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/list")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping(path="/delete")
	public @ResponseBody String deleteUser (@RequestParam int id) {
		
		userRepository.deleteById(id);
		return "Delete successfully!";
	}
	
	@PostMapping(path="/update")
	public @ResponseBody String updateUser (@RequestParam int id, @RequestParam String name, @RequestParam String surname ) {
		
		User n = new User();
		n.setId(id);
		n.setName(name);
		n.setSurname(surname);
		userRepository.save(n);
		return "Update successfuly";
	}
	
	
	
}