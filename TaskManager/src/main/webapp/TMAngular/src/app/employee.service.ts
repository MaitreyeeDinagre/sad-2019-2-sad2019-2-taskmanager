import { Injectable } from '@angular/core';
import { employee } from './employee.model';
import { HttpClient } from '@angular/common/http';
import { emp } from './emp.model';
import { issue } from './issue.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  form : FormData;
  form2 : FormData;
  readonly rootURL = 'http://localhost:8888/JIRA-lite/TaskManager';

  constructor(private httpClient : HttpClient) { }
    
    postEmployee(form : employee) {
      this.form = new FormData();
      this.form.append("employeeDetails", "First Full Entry",);
      this.form.append("employeeName", "qwertyuio");
      this.form.append("role", "1");
      this.form.append("profile", "1");
      this.form.append("initiative", "1");
      alert(form.employeedetails);
      return this.httpClient.post(
        this.rootURL + '/employee/', this.form);
    }

    deleteEmployee(empId : number) {
      return this.httpClient.delete(
        this.rootURL + '/issue/delete/' + empId);
    }

    updateIssue(issue : FormData) {
      /*this.form2 = new FormData();
      this.form2.append("issueId", "1");
      this.form2.append("issueDescription", "First Full Entry");
      this.form2.append("issueName", "issueName1");
      this.form2.append("status", "2");
      this.form2.append("story", "1");*/
      return this.httpClient.put(
        this.rootURL + '/issue/update/', issue);
    }
/*
{
          "employeeDetails": "string",
          "employeeInitiative": 0,
          "employeeName": "string",
          "employeeProfile": 0,
          "employeerole": 0,
        }*/
  
}
