import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  } from '@angular/common/http';
import {issue} from './issue.model';

@Injectable({
  providedIn: 'root'
})
export class IssueService {

  url:'http://localhost:8888/JIRA-lite/TaskManager/issue/';

  constructor(private httpClient : HttpClient) {}

    form : FormData;
    form2 : FormData;
    readonly rootURL = 'http://localhost:8888/JIRA-lite/TaskManager';

  getIssueList() {
    return this.httpClient.get("http://localhost:8888/JIRA-lite/TaskManager/issue/");  
  }

  postIssue(issue : FormData) {
    alert(issue.get("issuedescription"));
    if(issue.has("issuedescription")) {
      this.form2 = new FormData();
      this.form2.append("issueDescription", issue.get("issuedescription"));
      this.form2.append("issueName", issue.get("issuename"));
      this.form2.append("status", "1");
      this.form2.append("story", "1");

      return this.httpClient.post(
        this.rootURL + '/issue/', this.form2);
    }
     else {
       alert("null");
        return null;
     } 
    
  }

  
}