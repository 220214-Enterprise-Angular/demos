import { Cat } from './../../cat';
import { CatService } from './../../services/cat.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  cats: Cat[] = []; // this array will hold the top 5 cats

  constructor(private catService: CatService) { }

  ngOnInit(): void {

    this.getTopCats();

  }

  getTopCats(): void {

    this.catService.getCats()
      .subscribe(allTheCats => this.cats = allTheCats.slice(0, 5));

  }

}
