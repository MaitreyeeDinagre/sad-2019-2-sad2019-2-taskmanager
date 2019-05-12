import { Component } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  emailId : string;
  password : string;
  loggedIn : boolean = true;
  loggedOut : boolean = !this.loggedIn;
  cookieValue = 'UNKNOWN';
  loggedUser : any;
  
  constructor(private cookieService : CookieService, private httpClient : HttpClient) { }

  ngOnInit() {
    if(this.cookieService.get('employeeId')) {
      this.loggedIn = true;
      this.loggedOut = !this.loggedIn;
    }
    else {
      this.loggedIn = false;
      this.loggedOut = !this.loggedIn;
    }
  }

  loginUser() {
    this.httpClient.get("http://localhost:8888/JIRA-lite/TaskManager/employee/login/" 
    + this.emailId + "/"+ this.password)
    .subscribe(Response => {
      this.loggedUser = Response;
      this.loggedIn = !this.loggedIn;
    this.loggedOut = !this.loggedIn;
    this.cookieService.set( 'employeeId', this.loggedUser.employeeId );
    this.cookieService.set( 'employeeInitiative', this.loggedUser.employeeInitiative );
    this.cookieService.set( 'employeeProfile', this.loggedUser.employeeProfile );

    window.location.href="http://localhost:4200/home";
      
      console.log(Response);
    });

    
  }
}
