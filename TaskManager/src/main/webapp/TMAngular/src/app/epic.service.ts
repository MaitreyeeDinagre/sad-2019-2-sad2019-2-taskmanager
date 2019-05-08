import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { epic } from './epic.model';

@Injectable({
  providedIn: 'root'
})
export class EpicService {

  form : FormData;
  form2 : FormData;
  readonly rootURL = 'http://localhost:8888/JIRA-lite/TaskManager';

  constructor(private httpClient : HttpClient) { }

  getEpicList() {
    return this.httpClient.get("http://localhost:8888/JIRA-lite/TaskManager/story/");  
  }

  postEpic(form : epic) {
    this.form = new FormData();
    this.form.append("epicName", "First Full Entry",);
    this.form.append("epicDescription", "qwertyuio");
    this.form.append("epicInitiative", "1");
    alert(this.form);
    return this.httpClient.post(
      this.rootURL + '/epic/', this.form);
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
