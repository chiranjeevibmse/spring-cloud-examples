package com.saartha.springclould.ems.department.controller;

import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saartha.springclould.ems.department.model.Department;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/department")
public class DepartmentRESTController {

	private final CrudRepository<Department, Long> repository;

	@Autowired
	public DepartmentRESTController(CrudRepository<Department, Long> repository) {
		this.repository = repository;
	}

	@PostMapping(path = "/create")
	@ResponseBody
	public Department createDepartment(@RequestBody Department department) throws DepartmentException {
		try {
			return this.repository.save(department);
		} catch (PersistenceException e) {
			log.error(e.getMessage());
			throw new DepartmentException(e.getMessage());
		}
	}

	@GetMapping(path="/{departmentId}")
	@ResponseBody
	@Nullable
	public Department getDepartmentById(@PathVariable(name = "departmentId") Long departmentId)
			throws DepartmentException {
		try {
			Optional<Department> departOption = this.repository.findById(departmentId);
			return departOption.isPresent() ? departOption.get() : null;
		} catch (PersistenceException e) {
			log.error(e.getMessage());
			throw new DepartmentException(e.getMessage());
		}
	}
	@ExceptionHandler
	public String getErrorMessage() {
		return "Error in department service";
	}
}
