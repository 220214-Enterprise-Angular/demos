import { MessageService } from './message.service';
import { Cat } from './../cat';
import { CATS } from './../mock-cats'; // Import the entire array from that file

import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

// At the core of Angular is Dependency Injection
// We will have to inject this service as a dependency in some components
// because the component depends on it to get data

// Injectable classes can be used (injected ) by other classes for their methods
@Injectable({ // anything marked with this means it participates in the dependency injection system
  providedIn: 'root'
})  // declares a class a a potential dependency
export class CatService {

  constructor(private messageService: MessageService) { }

  // right now this is asynchronous
  getCats(): Observable<Cat[]> {
    const cats = of(CATS); // of() returns an observable (a stream of data emit over time)
    this.messageService.add('CatService: fetched all the cats')
    return cats;
  }

  // asynchronous siugnature
  getCat(id: number): Observable<Cat> {

    const cat = CATS.find(c => c.id === id)!;
    this.messageService.add(`sCatService: fetched cat with id=${id}`)
    return of(cat);

  }
}
