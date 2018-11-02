package com.saartha.springclould.ems.department.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
public class Department {
	@Id
	@Getter
	@GeneratedValue
	private Long departmentId;
	@Getter
	@Setter
	private DEPARTMENTS type;
	@Getter
	@Setter
	private String departmentName;
}
