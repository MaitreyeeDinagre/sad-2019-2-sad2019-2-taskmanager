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

  postIssue(form : issue) {
    this.form = new FormData();
    this.form.append("issueName", "First Full Entry",);
    this.form.append("issueDescription", "qwertyuio");
    this.form.append("issueStory", "1");
    this.form.append("issueStatus", "1");
    alert(this.form);
    return this.httpClient.post(
      this.rootURL + '/issue/', this.form);
  }

}