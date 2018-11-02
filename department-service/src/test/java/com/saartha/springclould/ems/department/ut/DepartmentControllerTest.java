/**
 * 
 */
package com.saartha.springclould.ems.department.ut;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.saartha.springclould.ems.department.controller.DepartmentException;
import com.saartha.springclould.ems.department.controller.DepartmentRESTController;
import com.saartha.springclould.ems.department.data.DepartmentRepository;
import com.saartha.springclould.ems.department.model.DEPARTMENTS;
import com.saartha.springclould.ems.department.model.Department;

/**
 * @author chiranjeevi
 *
 */
@SpringBootTest()
@RunWith(SpringRunner.class)
public class DepartmentControllerTest {

	@MockBean
	private DepartmentRepository repositorty;

	@Autowired
	private DepartmentRESTController controller;

	/**
	 * Test method for
	 * {@link com.saartha.springclould.ems.department.controller.DepartmentRESTController#DepartmentRESTController(org.springframework.data.repository.Repository)}.
	 * 
	 * @throws DepartmentException
	 */
	@Test
	public void testDepartmentRESTController() throws DepartmentException {
		Department department = new Department();
		department.setDepartmentName("Test department");
		department.setType(DEPARTMENTS.ENGINEERING);
		given(this.repositorty.save(department)).willReturn(department);
		Department createDepartment = this.controller.createDepartment(department);

		assertNotNull(createDepartment);
		assertThat(createDepartment.getDepartmentName(), is("Test department"));
	}

	@Test
	public void testDepartmentGetWhichIsNotPresent() throws DepartmentException {
		given(this.repositorty.findById(1L)).willReturn(Optional.empty());

		this.controller.getDepartmentById(1l);
	}
	
	@Test
	public void testDepartmentIsPresent() throws DepartmentException {
		Department department = new Department();
		department.setDepartmentName("Test department");
		department.setType(DEPARTMENTS.ENGINEERING);
		given(this.repositorty.findById(1l)).willReturn(Optional.of(department));

		Department departmentById = this.controller.getDepartmentById(1l);
		assertNotNull(departmentById);
		assertThat(departmentById.getDepartmentName(),is("Test department"));
		assertThat(departmentById.getType(),is(DEPARTMENTS.ENGINEERING));
	}
}
