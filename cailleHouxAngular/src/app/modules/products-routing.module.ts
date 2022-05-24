import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListeCaillouxComponent} from "../components/product/liste-cailloux/liste-cailloux.component";
import {DetailsProductComponent} from "../components/product/details-product/details-product.component";

const routes: Routes = [
  { path: '', component: ListeCaillouxComponent},
  { path:'detailsProduct/:id', component:DetailsProductComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductsRoutingModule { }
