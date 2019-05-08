import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-timelog',
  templateUrl: './timelog.component.html',
  styleUrls: ['./timelog.component.css']
})
export class TimelogComponent implements OnInit {

  logDescription = new FormControl('');
  logDuration = new FormControl('');
  logStory= new FormControl('');
  logTask = new FormControl('');
  logEmployee = new FormControl('');

  issueDescription = new FormControl('');
  issueName = new FormControl('');
  issueStory= new FormControl('');
  issueStatus = new FormControl('');

  constructor() { }

  ngOnInit() {
  }

  timeLog() {
    alert("Time");
  }

  issueLog() {
    alert("Issue");
  }

}
