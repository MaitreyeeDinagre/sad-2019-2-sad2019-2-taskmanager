import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { employee } from './employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeserviceService {

  url = 'http://localhost:8888/JIRA-lite/TaskManager/employee/';
  
  
  constructor(private httpClient : HttpClient) { 
    employee;
    }

  getEmployeeList() {
    return this.httpClient.get("http://localhost:8888/JIRA-lite/TaskManager/employee/");  
  }
}
