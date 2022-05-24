import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListeCaillouxComponent} from "../components/product/liste-cailloux/liste-cailloux.component";
import {DetailsProductComponent} from "../components/product/details-product/details-product.component";
import {DashboardComponent} from "../vues/user/dashboard/dashboard.component";
import {LoginComponent} from "../vues/authentication/login/login.component";
import {RegisterComponent} from "../vues/authentication/register/register.component";

const routes: Routes = [
  { path: '', redirectTo: "login", pathMatch: "full"},
  { path:'login', component:LoginComponent},
  { path:'register', component:RegisterComponent},
  { path:'dashboard', component:DashboardComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsersRoutingModule { }
