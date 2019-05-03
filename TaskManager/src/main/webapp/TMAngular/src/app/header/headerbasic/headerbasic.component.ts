import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-headerbasic',
  templateUrl: './headerbasic.component.html',
  styleUrls: ['./headerbasic.component.css']
})
export class HeaderbasicComponent implements OnInit {

  isHome : boolean = true;
  isContact : boolean = false;
  isAccount : boolean = false;
  constructor(private http : HttpClient) {

   }

  ngOnInit() {
    this.isHome = true;
    this.isContact = false;
    this.isAccount = false;
  }

  homeClicked(){
    this.isHome = true;
    this.isContact = false;
    this.isAccount = false;
  }

  contactClicked(){
    this.isHome = false;
    this.isContact = true;
    this.isAccount = false;
  }

  accountClicked(){
    this.isHome = false;
    this.isContact = false;
    this.isAccount = true;
  }

}
