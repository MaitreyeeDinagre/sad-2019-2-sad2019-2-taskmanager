import { Component, OnInit } from '@angular/core';
import {task} from '../../task.model';
import {TaskService} from '../../task.service';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import{FormsModule} from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

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

  ngOnInit() {

    this.getTask();
  }

  constructor(private taskservice: TaskService , private httpclient : HttpClient) { }

  
  getTask(){

      return this.httpclient.get(this.taskUrl).subscribe( 
        response => {
            this.tasks = response;
            console.log(response);
        },
        error => {
          this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
        }
    );
  }
}