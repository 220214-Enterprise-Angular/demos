import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService { // we'll use this service when we've successfully performed some ooperation
                              // in the CatService

  messages: string[] = [];

  add(message: string) {
    this.messages.push(message);
  }

  clear() {
    this.messages = [];
  }

}
