package com.spring.springApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewDepartment (@RequestParam String departmentName) {
		
		Department d = new Department();
		d.setDepartmentName(departmentName);
		departmentRepository.save(d);
		return "Saved department";
	}

	@GetMapping(path="/list")
	public @ResponseBody Iterable<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	
	@PostMapping(path="/delete")
	public @ResponseBody String deleteDepartment (@RequestParam int id) {
		
		departmentRepository.deleteById(id);
		return "Delete successfully!";
	}
	
	@PostMapping(path="/update")
	public @ResponseBody String updateDepartment (@RequestParam int id, @RequestParam String departmentName) {
		
		Department d = new Department();
		d.setDep_id(id);
		d.setDepartmentName(departmentName);
		departmentRepository.save(d);
		return "Update successfuly";
	}
	
}
