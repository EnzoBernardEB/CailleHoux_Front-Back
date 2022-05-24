import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ListeCaillouxComponent} from "../components/product/liste-cailloux/liste-cailloux.component";
import {ProductsRoutingModule} from "./products-routing.module";
import {DetailsProductComponent} from "../components/product/details-product/details-product.component";



@NgModule({
  declarations: [
    ListeCaillouxComponent,
    DetailsProductComponent
  ],
  imports: [
    CommonModule,
    ProductsRoutingModule,
  ]
})
export class ProductsModule { }
