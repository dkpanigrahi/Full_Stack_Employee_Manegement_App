import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrl: './list-employee.component.css'
})
export class ListEmployeeComponent {

  employees:Employee[]=[];

  constructor(private employeeService:EmployeeService,private router:Router){}
  

  ngOnInit():void{
    this.getEmployees();
  }

  private getEmployees(){

    this.employeeService.getEmployeeList().subscribe(data =>{
    this.employees=data;
    })
  }

  updateEmployee(id:number){
      this.router.navigate(['update-employee',id])
  }

  deleteEmployee(id:number){
      this.employeeService.deleteEmployee(id).subscribe(data =>{
        console.log(data);
        this.getEmployees();
      })
  }

  viewEmployee(id:number){
    this.router.navigate(['employee-details',id])
  }


}
