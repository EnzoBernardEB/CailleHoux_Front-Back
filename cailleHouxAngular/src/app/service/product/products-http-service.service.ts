import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {products} from "../../constantes/urls/productURL";
import {Observable} from "rxjs";
import {Product} from "../../models/Product";

@Injectable({
  providedIn: 'root'
})
export class ProductsHttpService {
  constructor(private httpClient: HttpClient) { }

  getAllProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(products);
  }

  getProductById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(products+"/"+id);
  }
}
