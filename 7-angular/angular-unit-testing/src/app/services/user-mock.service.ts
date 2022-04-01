import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserMockService {

  /**
 * The “UserServiceMock” is a dummy service that
 * we created that returns dummy data to run the
 * tests of the component.
 */


  constructor() { }

  getUsers(): Array<{}> {

    return [
      {
        // JUST RETURN ONE OBJ LITERAL
        name: 'user1',
        username: 'username1'
      },
    ]

  }
}
