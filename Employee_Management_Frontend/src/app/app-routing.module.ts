import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListEmployeeComponent } from './list-employee/list-employee.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';

const routes: Routes = [

  {path:'employee',component:ListEmployeeComponent},
  {path:'create-employee',component:CreateEmployeeComponent},
  {path:'',redirectTo:'employee',pathMatch:'full'},
  {path:'update-employee/:id',component:UpdateEmployeeComponent},
  {path:'employee-details/:id',component:EmployeeDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
