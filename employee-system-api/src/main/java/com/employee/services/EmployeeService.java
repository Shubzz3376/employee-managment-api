package com.employee.services;

import java.util.List;

import com.employee.entity.EmployeeEntity;

public interface EmployeeService {

	EmployeeEntity createEmployee(EmployeeEntity e);

	List<EmployeeEntity> getAllEmployee();

	boolean deleteEmployee(Long id);

	EmployeeEntity getEmployeeById(Long id);

	EmployeeEntity updateEmployee(Long id, EmployeeEntity e);

}
