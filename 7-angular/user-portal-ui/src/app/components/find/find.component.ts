import { ClientMessage } from './../../models/client-message';
import { Component } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { subscribeOn } from 'rxjs';

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent {

  title = 'Find User By ID'
  // TODO: build a property to capture the user's input
  userId: number = 0;
  public user: User = new User(0, '', '', '', '', '', []); // why public? because we share the data with the html template
  public clientMessage: ClientMessage = new ClientMessage('');

  // inject the user service into this component so we can use it!
  constructor(private userSerivce: UserService) { }


  public findUser() {

    // call on a method from the UserService to find the user by ID taken from the template
    // pass through this.userId as the parameter to the service method
    this.userSerivce.findUserById(this.userId) // no semi colon here! Because we need to declare what we do to the data returned
      .subscribe( // takes in one or two functions
        data => {
          this.user = data;
          this.clientMessage.message = ''; // to take away error message
        },  // what to do in the case of success!
        () => this.clientMessage.message = `Can't Find the User with id ${this.userId}`,// what to do in the case of failure
        )

  }



  // TODO: define the getById() method in the UserService

}
