import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  getUsers(): Array<{}> {

    return [
      {
        // OBJ LITERAL 1
        name: 'user1',
        username: 'username1'
      },
      {
        // OBJ LITERAL 2
        name: 'user2',
        username: 'username2'
      }
    ]

  }

}
