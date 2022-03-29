import { UserService } from 'src/app/services/user.service';
import { ClientMessage } from './../../models/client-message';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-remove',
  templateUrl: './remove.component.html',
  styleUrls: ['./remove.component.css']
})
export class RemoveComponent  {

  title = 'Remove User by Id';
  userId: number = 0;
  public clientMessage: ClientMessage = new ClientMessage('');

  // TODO: inject the User Service into this component so we can call on its methods
  constructor(private userService: UserService) { }

  public removeUser() {

    // this will call the service's removeUserById() method
    this.userService.deleteUserById(this.userId)
      .subscribe(
        // WHAT TO DO IF IT'S SUCCESSFUL
        () => this.clientMessage.message = `Removed user with Id ${this.userId}`,
        // maybe the handleError() method was invoked in the .pipe()
        () => this.clientMessage.message = `Unable to remove user with id ${this.userId}`
      );

  }

}
