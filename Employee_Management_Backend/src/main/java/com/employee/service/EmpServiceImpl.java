package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public Employee saveEmp(Employee emp) {
		Employee e = empRepository.save(emp);
		return e;
	}

	@Override
	public List<Employee> getAllEmp() {
		 
		return empRepository.findAll();	
	}

	@Override
	public Employee getEmpByid(int id) {
		
		return empRepository.findById(id).get();
	}

	@Override
	public boolean deleteEmp(int id) {
		
		Employee emp = empRepository.findById(id).get();
		
		if(emp!=null) {
			empRepository.delete(emp);
			return true;
		}
		return false;
	}

	@Override
	public void updateEmployee(Employee emp, int empId) {
		emp.setId(empId);
		empRepository.save(emp);
		
	}

}
