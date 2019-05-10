import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { IssueService } from '../issue.service';
import { issue } from '../issue.model';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-timelog',
  templateUrl: './timelog.component.html',
  styleUrls: ['./timelog.component.css'],
  providers: [DatePipe]
})
export class TimelogComponent implements OnInit {

  logDescription : string;
  logDuration : number;
  logStory : number;
  logTask : number;
  logEmployee : number;

  issueDescription : string;
  issueName : string;
  issueStory : number;
  issueStatus : number;

  stories : any;
  tasks : any;
  statusList : any;

  selectedStoryId : number;
  selectedTaskId : number;
  issueStoryId : number;
  issueStatusId : number;
  
  issueForm : issue;
  form : FormData;
  readonly rootURL = 'http://localhost:8888/JIRA-lite/TaskManager';
  todayDate = new Date();
  dateString : string;
  constructor(private httpclient : HttpClient, private issueService : IssueService,
    private datePipe : DatePipe) { 
      this.dateString = this.datePipe.transform(this.todayDate, 'yyyy-mm-dd hh-mm-ss');
    }
  
  form2 : FormData;
  ngOnInit() {
    
    this.getPresets();
  }

  convertToString(value : number) {
    var x = value,
    toString = x.toString(),
    toConcat = x + "";
    return toConcat;
  }
  timeLog() {
    this.logStory = this.selectedStoryId;
    this.logTask = this.selectedTaskId;


    this.logEmployee = 1;

    //create log
    this.form = new FormData();
    this.form.append("timeLogDescription", this.logDescription);
    this.form.append("timeLogAudit", this.dateString);
    alert("this.logStory" +this.logStory);
    this.form.append("timeLogDuration", this.convertToString(this.logDuration));
    this.form.append("story", this.convertToString(this.logStory));
    this.form.append("employee", "1");
    this.form.append("task", this.convertToString(this.logTask));
      
    return this.httpclient.post(
      this.rootURL + '/timelog/', this.form)
      .subscribe( response => {
        alert("Time Logged");
        console.log("Kosko" +response);
        this.logDescription = null;
        this.logDuration = null;
        this.logStory = null;
        this.logTask = null;
      });
    
  }

  issueLog() {
    this.issueStory = this.issueStoryId;
    this.issueStatus = this.issueStatusId;
    
    this.issueForm = new issue;
    this.issueForm.issuename = this.issueName;
    this.issueForm.issuedescription = this.issueDescription;
    this.issueForm.issueStory = this.issueStory;
    this.issueForm.issueStatus = this.issueStatus;
    alert("issueDescription " +this.issueDescription);
    //create  issue
    this.form2 = new FormData();
    this.form2.append("issueDescription", this.issueDescription);
    this.form2.append("issueName", this.issueName);
    alert("this.issueStatus "+this.issueStory)
    this.form2.append("status", this.convertToString(this.issueStatusId));
    this.form2.append("story", this.convertToString(this.issueStoryId));
    alert("issueDescription " +this.form2.has("issueDescription"));
    
    return this.httpclient.post(
      this.rootURL + '/issue/', this.form2)
    .subscribe( response => {
      console.log("Kosko" +response);
      alert("Time Logged");
      this.issueDescription = null;
      this.issueName = null;
    });
  }

  getPresets() {
  
    this.httpclient
  .get('http://localhost:8888/JIRA-lite/TaskManager/story/')
  .subscribe( response => {
    this.stories = response;
    console.log(response);
  });

  this.httpclient
  .get('http://localhost:8888/JIRA-lite/TaskManager/task/')
  .subscribe( response => {
    this.tasks = response;
    console.log(response);
  });

  this.httpclient
  .get('http://localhost:8888/JIRA-lite/TaskManager/enum/status/')
  .subscribe( response => {
    this.statusList = response;
    console.log(response);
  });
  }

}
