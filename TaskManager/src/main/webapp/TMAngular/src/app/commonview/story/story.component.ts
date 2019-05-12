import { Component, OnInit } from '@angular/core';
import {StoryService} from '../../story.service'
import {HttpClient} from '@angular/common/http';
import {story} from '../../story.model';
import { Observable } from 'rxjs';
import{FormsModule} from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CookieService } from 'ngx-cookie-service';


@Component({
  selector: 'app-story',
  templateUrl: './story.component.html',
  styleUrls: ['./story.component.css']
})
export class StoryComponent implements OnInit {

  stories: any;
  story = new story();

  selectedEpicId : number;
  epics : any;

  employeeId : string;
  employeeProfile : string;
  employeeInitiative : string;

  constructor(private storyservice: StoryService , private httpclient : HttpClient,  private cookieService : CookieService) { }

  getStory(value : string){
  //alert(">>>>>>>> " + value.split(":")[1]);

    this.httpclient
  .get('http://localhost:8888/JIRA-lite/TaskManager/epicstorytask/getbyepic/' + this.selectedEpicId)
  .subscribe( response => {
    this.stories = response;
    console.log(response);
  });
  }

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



}
