import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent{

  username: string = '';
  password: string = '';

  loginErrMsg: string = '';
  isLoading: boolean = false; // look into Angular Material for loading animations


  constructor() { }

  // call on a service to take in the username and password and send
  // them to the /login endpoint of our server

  login() {

    // call the authService to hit the /login endpoint

  }

}
