import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CatsComponent } from './components/cats/cats.component';
import { FormsModule } from '@angular/forms';
import { CatDetailComponent } from './components/cat-detail/cat-detail.component';
import { MessagesComponent } from './components/messages/messages.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';

@NgModule({ // contains critical data about the pieces of our app and how they work together
  declarations: [
    AppComponent,
    CatsComponent,
    CatDetailComponent,
    MessagesComponent,
    DashboardComponent
  ],
  imports: [ // this contains a list of external modules that the app needs
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
