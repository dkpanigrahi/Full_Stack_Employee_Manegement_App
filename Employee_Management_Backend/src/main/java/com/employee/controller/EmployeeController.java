package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.employee.entity.Employee;
import com.employee.service.EmpService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

		@Autowired
		private EmpService empService;
		
		@PostMapping("/employee")
		public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
			
			Employee em = null;
			try {
			    em = empService.saveEmp(emp);
				return ResponseEntity.status(HttpStatus.CREATED).build(); 
			
			} catch (Exception e) {
				
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
	
	
		
		@GetMapping("/employee")
		public ResponseEntity<List<Employee>> getEmployee()
		{
			List<Employee> list = empService.getAllEmp();
			if(list.size()<= 0)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}

		
	
		@GetMapping("/employee/{id}")
		public ResponseEntity<Employee> getBook(@PathVariable int id)
		{
			Employee emp = empService.getEmpByid(id);
			if(emp == null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(emp);
		}
		
		
		
		@DeleteMapping("/employee/{employeeId}")
		public ResponseEntity<Void> deleteBook(@PathVariable int employeeId)
		{
			try {
				this.empService.deleteEmp(employeeId);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		
		@PutMapping("/employee/{employeeId}")
		public ResponseEntity<Employee> updateBook(@RequestBody Employee emp,@PathVariable("employeeId") int empId)
		{
			try {
				this.empService.updateEmployee(emp,empId);
				return ResponseEntity.ok().body(emp);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
	
	
}
