import { Injectable } from '@angular/core';
import { task } from './task.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  form : FormData;
  form2 : FormData;
  readonly rootURL = 'http://localhost:8888/JIRA-lite/TaskManager';

  constructor(private httpClient : HttpClient) { }

  postTask(form : task) {
    this.form = new FormData();
    this.form.append("taskname", "First Full Entry",);
    this.form.append("taskdescription", "qwertyuio");
    this.form.append("taskestimatedtime", "20");
    this.form.append("taskactualtime", "20");
    this.form.append("taskStatus", "1");
    this.form.append("taskAssignedTo", "1");
    
    return this.httpClient.post(
      this.rootURL + '/task/', this.form)
      .subscribe(Response => {
        this.postEpicStoryTask(1, 1, 1);
      });
  }

  deleteTask(taskId : number) {
    return this.httpClient.delete(
      this.rootURL + '/task/delete/'+1);
  }

  updateTask(task : task) {
    this.form2 = new FormData();
    this.form2.append("taskId", "1");
    this.form2.append("taskDescription", "First Full Entry");
    this.form2.append("taskName", "taskname1");
    this.form2.append("taskestimatedtime", "2");
    this.form2.append("taskactualtime", "1");
    this.form.append("taskStatus", "1");
    this.form.append("taskAssignedTo", "1");
    return this.httpClient.put(
      this.rootURL + '/task/update/', this.form2);
  }

  postEpicStoryTask(epicId : number, storyId : number, taskId : number) {
    this.form = new FormData();
    this.form.append("epicStoryTaskStory", "1");
    this.form.append("epicStoryTaskTask", "1");
    this.form.append("epicStoryTaskEpic", "1");
    
    return this.httpClient.post(
      this.rootURL + '/storytask/', this.form)
      .subscribe(Response => {
        this.postEpicStoryTask(1, 1, 1);
      });
  }
}