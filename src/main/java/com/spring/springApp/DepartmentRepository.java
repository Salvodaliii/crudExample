package com.spring.springApp;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

	public Department findByDepartmentName(String departmentName);
}
