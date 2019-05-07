import { Component, OnInit } from '@angular/core';
import {StoryService} from '../../story.service'
import {HttpClient} from '@angular/common/http';
import {story} from '../../story.model';
import { Observable } from 'rxjs';
import{FormsModule} from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-story',
  templateUrl: './story.component.html',
  styleUrls: ['./story.component.css']
})
export class StoryComponent implements OnInit {

  stories: any;
  story = new story();
  constructor(private storyservice: StoryService , private httpclient : HttpClient) { }

  getStory(){

    this.httpclient
  .get('http://localhost:8888/JIRA-lite/TaskManager/story/')
  .subscribe( response => {
    this.stories = response;
    console.log(response);
  });
  }

  ngOnInit() {
    this.getStory();
  }

}
