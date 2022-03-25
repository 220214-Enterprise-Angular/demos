import { MessageService } from './../../services/message.service';
import { CatService } from './../../services/cat.service';
import { CATS } from './../../mock-cats';
import { Cat } from './../../cat'; // use the auto-import extension
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-cats',
  templateUrl: './cats.component.html',
  styleUrls: ['./cats.component.css']
})
export class CatsComponent implements OnInit {

  cats: Cat[] = [];
  selectedCat?: Cat; // ? marks a variable as an Optional - could possibly be null

  // we inject the CatService INTO this component so that the service provides the data that's displayed
  constructor(private catService: CatService, private messageService: MessageService) { } // one instance of a service created in an application

  // life-cycle hook! - WHEN the component is loaded, do this...
  ngOnInit(): void {
    // when the component is initialized, we call the getCats() method
    this.getCats(); // calls the below method
  }

  getCats(): void {
    this.catService.getCats() // you must subscribe to obseravbles
      .subscribe(catData => this.cats = catData); // pass a callback to declare what you do with the data recieved
      // .subscribe() passes the emitted array to a callback function
    }

  // we will bind this method to the click event on the button
  onSelect(cat: Cat): void {
    // set a selectedCat property
    this.selectedCat = cat;
    this.messageService.add(`CatsComponent: Selected cat name=${cat.name}`)
  }

}
