import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isManager : boolean;
  employeeId : string;
  employeeProfile : string;
  employeeInitiative : string;
  constructor(private cookieService : CookieService) { }

  ngOnInit() {

    if(this.cookieService.get('employeeId')) {
      alert("User Cookie Available");
      this.employeeId = this.cookieService.get('employeeId');
      this.employeeProfile = this.cookieService.get('employeeProfile');
      this.employeeInitiative = this.cookieService.get('employeeInitiative');

      this.isManager = (this.employeeProfile == "1") ? true : false;
    }
    else {
      alert("No Cookie");
    }

  }

}
