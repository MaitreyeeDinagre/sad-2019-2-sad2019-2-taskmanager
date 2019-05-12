import { Component, OnInit } from '@angular/core';
import {story} from '../story.model';
import { HttpClient } from '@angular/common/http';
import { Chart } from 'chart.js';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  story : any[];

  selectedEpicId : number;
  selectedStoryId : number;
  employeeId : string;
  employeeProfile : string;
  employeeInitiative : string;
  epics : any;
  stories : any;
  issues : any;
  constructor(private httpclient:HttpClient,   private cookieService : CookieService) { }

  ngOnInit() {
    if(this.cookieService.get('employeeId')) {
      this.employeeId = this.cookieService.get('employeeId');
      this.employeeProfile = this.cookieService.get('employeeProfile');
      this.employeeInitiative = this.cookieService.get('employeeInitiative');
    }
    else {
    }
    this.getEpicList();
    
  }

  getEpicList() {
    this.httpclient
    .get('http://localhost:8888/JIRA-lite/TaskManager/epic/getbyinitiative/' + this.employeeInitiative)
    .subscribe( response => {
      this.epics = response;
      console.log(response);
      
    });
  }

  getStory(value : string) {

    this.httpclient
    .get('http://localhost:8888/JIRA-lite/TaskManager/epicstorytask/getbyepic/' + this.selectedEpicId)
    .subscribe( response => {
      this.stories = response;
      console.log(this.stories);
      
    });

  }

  getIssue() {
    //http://localhost:8888/JIRA-lite/TaskManager/issue/getbystory/1

    this.httpclient
    .get('http://localhost:8888/JIRA-lite/TaskManager/issue/getbystory/' + this.selectedStoryId)
    .subscribe( response => {
      this.issues = response;
      console.log(this.stories);
      
    });
  }
}
