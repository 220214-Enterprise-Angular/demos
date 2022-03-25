import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatDetailComponent } from './components/cat-detail/cat-detail.component';
import { CatsComponent } from './components/cats/cats.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';

// http://localhost:4200/cat-app/cats when a button is clicked here

// request is sent to Spring boot http://localhost:5000/api/users/add
const routes: Routes = [

  // when the application starts, it will go to the /dashboard path
  {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  {path: 'cats' , component: CatsComponent},
  {path: 'dashboard', component: DashboardComponent},

  // :id is a placeholder to capture whatever cat id you want to see the details of
  {path: 'detail/:id', component: CatDetailComponent},

  // WildCard route ALWAYS must be last
  {path: '**', component: DashboardComponent }

];

@NgModule({ // contains critical data about the pieces of our app and how they work together
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
