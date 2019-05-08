import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/employee.service';
import { issue } from 'src/app/issue.model';

@Component({
  selector: 'app-employeelistview',
  templateUrl: './employeelistview.component.html',
  styleUrls: ['./employeelistview.component.css']
})
export class EmployeelistviewComponent implements OnInit {

  constructor(private empService : EmployeeService) { }

  ngOnInit() {
  }

  deleteEmployee(empId : number) {
    this.empService.deleteEmployee(empId)
    .subscribe(Response => {
      //Success Mesaage
      console.log("DEleted");
    });
  }

  updateIssue(issue : issue) {
    this.empService.updateIssue(issue)
    .subscribe(Response => {
      console.log("Updated");
    });
  }
}
