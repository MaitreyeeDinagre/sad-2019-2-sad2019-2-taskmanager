import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterModule } from './footer/footer.module';
import { HeaderModule } from './header/header.module';
import { ManagerviewModule } from './managerview/managerview.module';
import { CommonviewModule } from './commonview/commonview.module';
import { TasklogModule } from './tasklog/tasklog.module';
import { EmployeeserviceService } from './employeeservice.service';
import { CookieService } from 'ngx-cookie-service/cookie-service/cookie.service';
import { FormsModule } from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { EpicService } from './epic.service';
import { StoryService } from './story.service';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FooterModule,
    HeaderModule,
    ManagerviewModule,
    CommonviewModule,
    TasklogModule,
    FormsModule,
    NgbModule.forRoot()
  ],
  providers: [EmployeeserviceService, CookieService, EpicService,StoryService ],
  bootstrap: [AppComponent]
})
export class AppModule { }