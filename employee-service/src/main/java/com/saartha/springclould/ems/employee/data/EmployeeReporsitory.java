/**
 * 
 */
package com.saartha.springclould.ems.employee.data;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saartha.springclould.ems.employee.model.Employee;

/**
 * @author chiranjeevi
 *
 */
@Repository
public interface EmployeeReporsitory extends CrudRepository<Employee, UUID> {

}
