import { url } from './../../environments/environment'; // imports the URL that points to localhost:5000/api....
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


// This UserService is entirely responsible for making HTTP requests to the UserController

const userUrl = url + `/users`; // now the url is pointing to http://localhost:5000/api/users/

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // inject ANOTHER service into this service
  // first add HttpClient Module to your app.module.ts file
  constructor(private http: HttpClient) { }

  registerUser() {

  }

}
