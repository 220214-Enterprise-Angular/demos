import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cats',
  templateUrl: './cats.component.html',
  styleUrls: ['./cats.component.css']
})
export class CatsComponent implements OnInit {

  // declaring our first property of this Component class
  cat = 'Winston';

  constructor() { }

  // life-cycle hook! - WHEN the component is loaded, do this...
  ngOnInit(): void {

  }

}
