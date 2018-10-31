package com.saartha.springclould.ems.department.data;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saartha.springclould.ems.department.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, UUID> {
	@Override
	Iterable<Department> findAll();

	@Override
	Optional<Department> findById(UUID id);

	@Override
	Department save(Department entity);
}
