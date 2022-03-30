import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './components/nav/nav.component';
import { MainComponent } from './components/main/main.component';
import { RegisterComponent } from './components/register/register.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AllComponent } from './components/all/all.component';
import { FindComponent } from './components/find/find.component';
import { RemoveComponent } from './components/remove/remove.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    MainComponent,
    RegisterComponent,
    AllComponent,
    FindComponent,
    RemoveComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, // this is necessary for [(ngModel)] & 2-way data binding
    HttpClientModule // this allows us to import HttpClient into our User Service
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
