import { CATS } from './../../mock-cats';
import { Cat } from './../../cat'; // use the auto-import extension
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-cats',
  templateUrl: './cats.component.html',
  styleUrls: ['./cats.component.css']
})
export class CatsComponent implements OnInit {

  cats = CATS;
  selectedCat?: Cat; // ? marks a variable as an Optional - could possibly be null

  constructor() { }

  // life-cycle hook! - WHEN the component is loaded, do this...
  ngOnInit(): void {

  }

  // we will bind this method to the click event on the button
  onSelect(cat: Cat): void {
    // set a selectedCat property
    this.selectedCat = cat;
  }

}
