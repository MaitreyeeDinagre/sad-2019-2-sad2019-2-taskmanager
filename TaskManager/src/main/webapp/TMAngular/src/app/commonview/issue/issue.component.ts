import { Component, OnInit } from '@angular/core';
import {issue} from '../../issue.model';
import {IssueService} from '../../issue.service';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import{FormsModule} from '@angular/forms';

@Component({
  selector: 'app-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css']
})
export class IssueComponent implements OnInit {

  issues: any;
  issue = new issue();

  constructor(private issueservice: IssueService , private httpclient : HttpClient) { }

  getIssue(){

    this.httpclient
  .get('http://localhost:8888/JIRA-lite/TaskManager/issue/')
  .subscribe( response => {
    this.issues = response;
    console.log(response);
  });
  }

  ngOnInit() {

    this.getIssue();
  }
    
}
