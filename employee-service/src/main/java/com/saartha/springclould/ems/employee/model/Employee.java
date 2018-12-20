package com.saartha.springclould.ems.employee.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	@Getter
	private UUID employeeId;
	@Getter
	@Setter
	private String firstName;
	@Getter
	@Setter
	private String lastName;
	@Getter
	@Setter
	private GENDER gender;
	@Getter
	@Setter
	private Integer departmentId;
}
