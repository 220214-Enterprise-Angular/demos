import { UserService } from './../../services/user.service';
import { ClientMessage } from './../../models/client-message';
import { User, Address } from './../../models/user';
import { Component } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  title = 'Register User';

  public user = new User(0, '', '', '', '', '', []);
  public address = new Address('', '', '', '', '');
  public clientMessage = new ClientMessage('');

  // Step 1. Capture the user info from the form, and build a user object

  // Step 2. Send a POST request to the Spring Boot API with the user object in the Request Body
  // (We need HttpService for this, which is in tunr iunjected into the UserService)

  constructor(private userService: UserService) { }

  public registerUser(): void {

    console.log(this.user);

    // call upon a service to transmit the object via HTTP to a backend API
    this.user.addresses.push(this.address);

    // send the user object to Spring Boot to persist in the db
    this.userService.registerUser(this.user)
      .subscribe(
        data => this.clientMessage.message = `Successfully registered ${data.firstName}`,
        error => this.clientMessage.message = `Something went wrong. Error ${error}`);
  }
}
