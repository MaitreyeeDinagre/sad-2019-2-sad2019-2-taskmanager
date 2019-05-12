import { Component, OnInit } from '@angular/core';
import {task} from '../../task.model';
import {TaskService} from '../../task.service';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import{FormsModule} from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  errorMessage: string;
  task = new task();
  tasks: any;
  private taskUrl = 'http://localhost:8888/JIRA-lite/TaskManager/task/';

  epics : any;
  selectedEpicId : number;

  employeeId : string;
  employeeProfile : string;
  employeeInitiative : string;

  ngOnInit() {

    if(this.cookieService.get('employeeId')) {
      this.employeeId = this.cookieService.get('employeeId');
      this.employeeProfile = this.cookieService.get('employeeProfile');
      this.employeeInitiative = this.cookieService.get('employeeInitiative');
    }
    else {
    }
    this.getEpic();
  }

  constructor(private taskservice: TaskService , private httpclient : HttpClient,  private cookieService : CookieService) { }

  
  getTask(value : string){

      return this.httpclient.get("http://localhost:8888/JIRA-lite/TaskManager/epicstorytask/getbyepic/" + value.split(":")[1])
      .subscribe( 
        response => {
            this.tasks = response;
            console.log(response);
        },
        error => {
          this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
        }
    );
  }

  getEpic(){

    this.httpclient
  .get('http://localhost:8888/JIRA-lite/TaskManager/epic/getbyinitiative/' + this.employeeInitiative)
  .subscribe( response => {
    this.epics = response;
    console.log(response);
  });
  }
}