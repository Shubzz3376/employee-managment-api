package com.employee.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeEntity createEmployee(EmployeeEntity e) {
		
		employeeRepository.save(e);
		return e;
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public boolean deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		EmployeeEntity employee = employeeRepository.findById(id).get();
		employeeRepository.delete(employee);
		return true;
	}

	@Override
	public EmployeeEntity getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public EmployeeEntity updateEmployee(Long id, EmployeeEntity e) {
		
		EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
		employeeEntity.setFirstName(e.getFirstName());
		employeeEntity.setLastName(e.getLastName());
		employeeEntity.setEmailId(e.getEmailId());
		
		employeeRepository.save(employeeEntity);
		return employeeEntity;
	}

}
