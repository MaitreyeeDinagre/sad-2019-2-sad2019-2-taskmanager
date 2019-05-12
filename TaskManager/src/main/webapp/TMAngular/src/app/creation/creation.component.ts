import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-creation',
  templateUrl: './creation.component.html',
  styleUrls: ['./creation.component.css']
})
export class CreationComponent implements OnInit {

  employeeId : string;
  employeeProfile : string;
  employeeInitiative : string;

  form : FormData;
  epicDescription : string;
  epicName : string;

  constructor(private httpClient : HttpClient, private cookieService : CookieService) { }

  ngOnInit() {
    if(this.cookieService.get('employeeId')) {
      this.employeeId = this.cookieService.get('employeeId');
      this.employeeProfile = this.cookieService.get('employeeProfile');
      this.employeeInitiative = this.cookieService.get('employeeInitiative');
    }
    else {
    }
  }

  convertToString(value : number) {
    var x = value,
    toString = x.toString(),
    toConcat = x + "";
    return toConcat;
  }

  createEpic() {

    this.form = new FormData();
      this.form.append("epicName", "Name",);
      this.form.append("epicDescription", "qwertyuio");
      this.form.append("epicInitiative", this.employeeInitiative);

    this.httpClient.post("http://localhost:8888/JIRA-lite/TaskManager/epic/", this.form)
    .subscribe(Response => {
      //Success Mesaage
      console.log(Response);
      //Reset Form
    });
  }

  createStory() {
    alert("createStory()");
  }

  createTask() {
    alert("createTask()");
  }

}
