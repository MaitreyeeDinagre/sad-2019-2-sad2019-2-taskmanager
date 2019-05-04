import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FooterModule,
    HeaderModule,
    LoginModule,
    ManagerviewModule,
    CommonviewModule,
    TasklogModule
  ],
  providers: [EmployeeserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
