import { Component, OnInit } from '@angular/core';
import { employee } from '../employee.model';
import { role } from '../role.model';
import { profile } from '../profile.model';
import { initiative } from '../initiative.model';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  employeeDetail = new employee;
  employeeProfile = new profile;
  employeeRole = new role;
  employeeInitiative = new initiative;

  loggedIn : boolean = true;
  loggedOut : boolean = !this.loggedIn;
  cookieValue = 'UNKNOWN';

  constructor(private cookieService : CookieService) { 

    this.employeeProfile.profileid = 1;
    this.employeeProfile.profilename = "Profile 1";
    this.employeeProfile.profiledescription = "";

    this.employeeRole.roleid = 1;
    this.employeeRole.rolename = "Role 1";
    this.employeeRole.roledescription = "";

    this.employeeInitiative.initiativeid = 1;
    this.employeeInitiative.initiativename = "Initiative 1";
    this.employeeInitiative.initiativedescription = "";

    this.employeeDetail.employeeid = 1;
    this.employeeDetail.employeename = "Kosko";
    this.employeeDetail.employeeprofile = this.employeeProfile;
    this.employeeDetail.employeerole = this.employeeRole;
    this.employeeDetail.employeedetails = "";
    this.employeeDetail.employeeinitiative = this.employeeInitiative;
  }

  ngOnInit() {
    this.employeeProfile.profileid = 1;
    this.employeeProfile.profilename = "Profile 1";
    this.employeeProfile.profiledescription = "";

    this.employeeRole.roleid = 1;
    this.employeeRole.rolename = "Role 1";
    this.employeeRole.roledescription = "";

    this.employeeInitiative.initiativeid = 1;
    this.employeeInitiative.initiativename = "Initiative 1";
    this.employeeInitiative.initiativedescription = "";

    this.employeeDetail.employeeid = 1;
    this.employeeDetail.employeename = "Kosko";
    this.employeeDetail.employeeprofile = this.employeeProfile;
    this.employeeDetail.employeerole = this.employeeRole;
    this.employeeDetail.employeedetails = "";
    this.employeeDetail.employeeinitiative = this.employeeInitiative;
  }

  logoutUser() {
    this.cookieService.deleteAll();
    this.loggedIn = false;
    this.loggedOut = !this.loggedIn;
    window.location.href="http://localhost:4200";
  } 

}
