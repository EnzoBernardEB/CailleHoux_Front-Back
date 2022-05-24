import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./vues/user/home/home.component";
import {Page404Component} from "./components/page404/page404.component";

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent},
  {
    path: 'products', loadChildren: () => import('./modules/products.module').then(m => m.ProductsModule),
  },
  {
    path: 'users', loadChildren: () => import('./modules/users.module').then(m => m.UsersModule),
  },
  { path: '**', component: Page404Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
