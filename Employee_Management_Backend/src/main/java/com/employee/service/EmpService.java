package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmpService {

    public Employee saveEmp(Employee emp);
	
	public List<Employee> getAllEmp();
	
	public Employee getEmpByid(int id);
	
	public boolean deleteEmp(int id);

	public void updateEmployee(Employee emp, int empId);
}
