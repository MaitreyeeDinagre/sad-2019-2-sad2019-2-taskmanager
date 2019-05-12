import { Component, OnInit } from '@angular/core';
import {epic} from '../../epic.model';
import {EpicService} from '../../epic.service';
import {HttpClient} from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-epic',
  templateUrl: './epic.component.html',
  styleUrls: ['./epic.component.css']
})
export class EpicComponent implements OnInit {

  
  epic : any;
  epics: any;

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

  constructor(private epicservice: EpicService , private httpclient : HttpClient, private cookieService : CookieService) { }

  
  getEpic(){

    this.httpclient
  .get('http://localhost:8888/JIRA-lite/TaskManager/epic/getbyinitiative/' + this.employeeInitiative)
  .subscribe( response => {
    this.epics = response;
    console.log(response);
  });
  }
}
