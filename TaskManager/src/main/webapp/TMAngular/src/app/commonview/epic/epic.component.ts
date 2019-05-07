import { Component, OnInit } from '@angular/core';
import {epic} from '../../epic.model';
import {EpicService} from '../../epic.service';
import {HttpClient} from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-epic',
  templateUrl: './epic.component.html',
  styleUrls: ['./epic.component.css']
})
export class EpicComponent implements OnInit {

  
  epic : any;
  epics: any;

  ngOnInit() {

    this.getEpic();
  }

  constructor(private epicservice: EpicService , private httpclient : HttpClient) { }

  
  getEpic(){

    this.httpclient
  .get('http://localhost:8888/JIRA-lite/TaskManager/epic/')
  .subscribe( response => {
    this.epics = response;
    console.log(response);
  });
  }
}
