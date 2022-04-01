import { UserService } from 'src/app/services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  text =  'user page';
  users; // this is initialized upon instnatiateion with the 2 users handed off from the service


  constructor(private userService: UserService) {

    this.users = this.userService.getUsers();

   }

}
