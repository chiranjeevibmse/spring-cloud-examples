package com.saartha.springclould.ems.employee.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saartha.springclould.ems.employee.model.Employee;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeRESTController {

	private final Repository<Employee, UUID> repository;

	@Autowired
	public EmployeeRESTController(Repository<Employee, UUID> repository) {
		this.repository = repository;
	}

}
