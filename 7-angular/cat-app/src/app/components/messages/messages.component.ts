import { MessageService } from './../../services/message.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  // I am injecting the MessageService into this component for the purpose of
  // capturing its message array and displaying it in this compoenet's html tempalte....
  constructor(public messageService: MessageService) { }
  // we need to make it public to access it outside of this file

  ngOnInit(): void {
  }

}
