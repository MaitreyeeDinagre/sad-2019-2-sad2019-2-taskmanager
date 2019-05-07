import { Component } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  loggedIn : boolean = true;
  loggedOut : boolean = !this.loggedIn;
  cookieValue = 'UNKNOWN';
  
  constructor(private cookieService : CookieService) { }

  ngOnInit() {
    if(this.cookieService.get('Test')) {
      alert("User Cookie Available");
      this.loggedIn = true;
      this.loggedOut = !this.loggedIn;
    }
    else {
      alert("User Cookie Unavailable");
      this.loggedIn = false;
      this.loggedOut = !this.loggedIn;
    }
  }
  
  logoutUser() {
    this.cookieService.deleteAll();
    alert("User Cookie Deleted");
    this.loggedIn = !this.loggedIn;
    this.loggedOut = !this.loggedIn;
  } 

  loginUser() {
    this.loggedIn = !this.loggedIn;
    this.loggedOut = !this.loggedIn;
    this.cookieService.set( 'Test', 'Developer', );
    alert("User Cookie Created");
    //this.cookieValue = this.cookieService.get('Test');
    //cookieService.delete('test');
  }
}
