import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/employee.service';
import { issue } from 'src/app/issue.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-employeelistview',
  templateUrl: './employeelistview.component.html',
  styleUrls: ['./employeelistview.component.css']
})
export class EmployeelistviewComponent implements OnInit {

  constructor(private empService : EmployeeService, private httpclient: HttpClient) { }

  selectedEmployeId : number;
  employees : any;
  ngOnInit() {
    this.presets();
  }

  deleteEmployee() {
    if(this.selectedEmployeId) {
      this.empService.deleteEmployee(this.selectedEmployeId)
      .subscribe(Response => {
        alert("Deleted");
        //Success Mesaage
        console.log("Deleted");
      });
    }
    else {
      alert("Select Employee");
    }
      
  }

  updateIssue(issue : issue) {
    this.empService.updateIssue(null)
    .subscribe(Response => {
      console.log("Updated");
    });
  }

  presets() {
    this.httpclient
  .get('http://localhost:8888/JIRA-lite/TaskManager/issue/')
  .subscribe( response => {
    this.employees = response;
    console.log(response);
  });
  }
}
