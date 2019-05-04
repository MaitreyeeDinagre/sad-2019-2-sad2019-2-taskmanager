import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeelistComponent } from './employeelist/employeelist.component';

@NgModule({
  declarations: [EmployeelistComponent],
  imports: [CommonModule],
  exports: [EmployeelistComponent]
})
export class ManagerviewModule { }
