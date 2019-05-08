import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/employee.service';
import { NgForm, FormBuilder } from '@angular/forms';
import { employee } from 'src/app/employee.model';
import { HttpClient } from '@angular/common/http';
import { emp } from 'src/app/emp.model';
import { role } from 'src/app/role.model';
import { initiative } from 'src/app/initiative.model';
import { profile } from 'src/app/profile.model';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(private empService : EmployeeService, private formBuilder: FormBuilder, private httpClient : HttpClient) { }

  uploadForm: employee;
  tempRole: role;
  tempIni: initiative;
  tempProfile: profile;


  ngOnInit() {
    this.uploadForm = new employee();
    this.uploadForm.employeeid = null;
    this.uploadForm.employeename = "";
    this.uploadForm.employeedetails = "";
    this.uploadForm.employeerole = null;
    this.uploadForm.employeeprofile = null;
    this.uploadForm.employeeinitiative = null;
    
  }

  resetForm() {
    this.uploadForm = new employee();
    this.uploadForm.employeeid = null;
    this.uploadForm.employeename = "";
    this.uploadForm.employeedetails = "";
    this.uploadForm.employeerole = null;
    this.uploadForm.employeeprofile = null;
    this.uploadForm.employeeinitiative = null;
  }

  submitForm() {
    if(this.uploadForm.employeename && this.uploadForm.employeedetails && this.uploadForm.employeeroleid &&
      this.uploadForm.employeeprofileid && this.uploadForm.employeeinitiativeid) {

        this.tempRole = new role();
        this.tempRole.roleid = 1;
        this.tempRole.rolename = "Manager";
        this.tempRole.roledescription = "Manager";
    
        this.tempProfile = new profile();
        this.tempProfile.profileid = 1;
        this.tempProfile.profilename = "SeniorConsultant";
        this.tempProfile.profiledescription = "Architects and Managers";
        
        this.tempIni = new initiative();
        this.tempIni.initiativeid = 1;
        this.tempIni.initiativename = "Initiative1";
        this.tempIni.initiativedescription = "Project #1";

        this.uploadForm.employeerole = this.tempRole;
        this.uploadForm.employeeprofile = this.tempProfile;
        this.uploadForm.employeeinitiative = this.tempIni;

        alert();
      //Post Method
      this.insertEmployee(this.uploadForm);
      
    }
    else {
      alert("Data Invalid");
      this.resetForm();
    }

  }

  insertEmployee(emp : employee) {
    alert(emp.employeedetails);
    this.empService.postEmployee(emp)
    .subscribe(Response => {
      //Success Mesaage
      console.log("fsdfsd");
      //Reset Form
      this.resetForm();
    });
  }

  
}
