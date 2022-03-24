import { Component } from '@angular/core';

// the x.component.ts file described the components properties & methods
@Component({ // the @Component decorator provides metadata about the component
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'Cat App to Learn Angular';

}
