import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EmployeeserviceService } from 'src/app/employeeservice.service';
import { employee } from 'src/app/employee.model';

@Component({
  selector: 'app-headerbasic',
  templateUrl: './headerbasic.component.html',
  styleUrls: ['./headerbasic.component.css']
})
export class HeaderbasicComponent implements OnInit {

  isProfile : boolean = false;
  isHome : boolean = true;
  isContact : boolean = false;
  isAccount : boolean = false;
  isDetails : boolean = false;

  EmployeeDetails : any;
  EmployeeList : any;
  listName : string[];
  constructor(private http : HttpClient, private employeeService : EmployeeserviceService) {

   }

  ngOnInit() {
    this.isHome = true;
    this.isContact = false;
    this.isAccount = false;
    this.isProfile = false;
    this.isDetails = false;
  }

  homeClicked(){
    this.isHome = true;
    this.isContact = false;
    this.isAccount = false;
    this.isProfile = false;
  }

  contactClicked(){
    this.isHome = false;
    this.isContact = true;
    this.isAccount = false;
    this.isProfile = false;

    this.http
    .get('http://localhost:8888/JIRA-lite/TaskManager/employee/')
    .subscribe( response => {
      this.EmployeeList = response;
      console.log(response);
      });
    }

  accountClicked(){
    this.isHome = false;
    this.isContact = false;
    this.isAccount = true;
    this.isProfile = false;
  }

  showDetails() {
    this.isDetails = !this.isDetails;
  }

  showProfile() {
    this.isHome = false;
    this.isContact = false;
    this.isAccount = false;
    this.isProfile = true;
    this.isDetails = false;

    this.http
    .get('http://localhost:8888/JIRA-lite/TaskManager/employee/1')
    .subscribe( response => {
      this.EmployeeDetails = response;
      console.log(response);
    })
    };
  }
