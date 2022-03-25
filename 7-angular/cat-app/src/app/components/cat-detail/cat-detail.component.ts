import { CatService } from './../../services/cat.service';
import { Cat } from './../../cat';
import { Component, OnInit, Input } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-cat-detail',
  templateUrl: './cat-detail.component.html',
  styleUrls: ['./cat-detail.component.css']
})
export class CatDetailComponent implements OnInit {

  // this cat property will be PASSED from the cat selected in the CatsComponent
  // this cat property is INPUT from the other component
  @Input() catToDisplay? : Cat; // the EXTERNAL component (CatsComponent will bind to it)

  constructor(
    private route: ActivatedRoute, // holds the inof about the route to this instance of the component
    private catService: CatService, // get cat data from the "remoter server" and get the cat to display
    private location: Location // Angular's service for interacting with the browser
  ) { }

  // extract the id from the url that brought us here
  ngOnInit(): void {

    this.getCatById();

  }

  getCatById(): void {

    // route.snapshot is a static image of the route info asfter the component was created
    // paramMap is a dictionary of the route param values extracted from the URL
    // route params are always String so we have to use the Number function to transform it to num
    const id = Number(this.route.snapshot.paramMap.get('id'));

    // call a method from the catService to retrieve the Cat by ID:
    this.catService.getCat(id)
      .subscribe(foundCat => this.catToDisplay = foundCat);
  }

  goBack(): void {
    this.location.back();
  }

}
