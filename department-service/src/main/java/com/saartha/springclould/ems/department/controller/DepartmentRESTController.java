package com.saartha.springclould.ems.department.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.saartha.springclould.ems.department.model.Department;

@RestController
public class DepartmentRESTController {
	private final Repository<Department, UUID> repository;
	@Autowired
	public DepartmentRESTController(Repository<Department, UUID> repository) {
		this.repository = repository;
	}
}
