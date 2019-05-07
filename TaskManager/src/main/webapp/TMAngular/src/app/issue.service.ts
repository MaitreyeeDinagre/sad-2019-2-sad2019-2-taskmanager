import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  } from '@angular/common/http';
import {issue} from './issue.model';

@Injectable({
  providedIn: 'root'
})
export class IssueService {

  url:'http://localhost:8888/JIRA-lite/TaskManager/issue/';

  constructor(private httpClient : HttpClient) {

    issue;
   }
   getIssueList() {
    return this.httpClient.get("http://localhost:8888/JIRA-lite/TaskManager/issue/");  
  }

}