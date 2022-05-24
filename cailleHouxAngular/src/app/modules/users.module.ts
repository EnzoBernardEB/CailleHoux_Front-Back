import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DashboardComponent} from "../vues/user/dashboard/dashboard.component";
import {LoginComponent} from "../vues/authentication/login/login.component";
import {RegisterComponent} from "../vues/authentication/register/register.component";
import {UsersRoutingModule} from "./users-routing.module";
import {FormsModule} from "@angular/forms";



@NgModule({
  declarations: [
    DashboardComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    CommonModule,
    UsersRoutingModule,
    FormsModule
  ]
})
export class UsersModule { }
