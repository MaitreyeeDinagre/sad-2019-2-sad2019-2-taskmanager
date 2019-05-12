import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterModule } from './footer/footer.module';
import { HeaderModule } from './header/header.module';
import { LoginComponent } from './login/login.component';
import { LoginModule } from './login/login.module';
import { ManagerviewModule } from './managerview/managerview.module';
import { CommonviewModule } from './commonview/commonview.module';
import { TasklogModule } from './tasklog/tasklog.module';
import { EmployeeserviceService } from './employeeservice.service';
import { CookieService } from 'ngx-cookie-service/cookie-service/cookie.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { EpicService } from './epic.service';
import { StoryService } from './story.service';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { TimelogComponent } from './timelog/timelog.component';
import { CreationComponent } from './creation/creation.component';
import { StatisticsComponent } from './statistics/statistics.component';
import { ProfileComponent } from './profile/profile.component';
import { profile } from './profile.model';
import { EmployeelistviewComponent } from './employees/employeelistview/employeelistview.component';
import { EmployeeService } from './employee.service';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeComponent } from './employees/employee/employee.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    HomeComponent,
    TimelogComponent,
    StatisticsComponent,
    ProfileComponent,
    CreationComponent,
    NotfoundComponent,
    EmployeesComponent,
    EmployeeComponent,
    EmployeelistviewComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FooterModule,
    HeaderModule,
    LoginModule,
    ManagerviewModule,
    CommonviewModule,
    TasklogModule,
    FormsModule,
    RouterModule.forRoot([
      {
        path : 'home',
        component : HomeComponent
      },
      {
        path : 'timelog',
        component : TimelogComponent
      },
      {
        path : 'creation',
        component : CreationComponent
      },
      {
        path : 'statistics',
        component : StatisticsComponent
      },
      {
        path : 'profile',
        component : ProfileComponent
      }
    ]),
    NgbModule.forRoot()
  ],
  providers: [EmployeeserviceService, CookieService, EpicService,StoryService, EmployeeService ],
  bootstrap: [AppComponent]
})
export class AppModule { }