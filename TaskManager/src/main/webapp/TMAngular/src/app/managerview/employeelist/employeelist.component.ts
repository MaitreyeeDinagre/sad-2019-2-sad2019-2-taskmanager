import { Component, OnInit } from '@angular/core';
import { EmployeeserviceService } from 'src/app/employeeservice.service';
import { employee } from 'src/app/employee.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent implements OnInit {

  employeeList : any;

  constructor(private employeeService : EmployeeserviceService, private httpClient : HttpClient) { 
    
    this.httpClient
    .get('http://localhost:8888/JIRA-lite/TaskManager/employee/')
    .subscribe( response => {
      this.employeeList = response;
      console.log(response);
    });

  }

  ngOnInit() {

   
    };
}
