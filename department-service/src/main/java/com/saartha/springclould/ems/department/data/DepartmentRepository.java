package com.saartha.springclould.ems.department.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saartha.springclould.ems.department.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
	@Override
	Iterable<Department> findAll();

	@Override
	Optional<Department> findById(Long id);

	@Override
	Department save(Department entity);
}
