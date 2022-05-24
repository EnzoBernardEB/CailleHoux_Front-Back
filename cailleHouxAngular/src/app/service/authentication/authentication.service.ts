import { Injectable } from '@angular/core';
import {UserRegister} from "../../models/UserRegister";
import {authentication} from "../../constantes/urls/usesURL";
import {HttpClient} from "@angular/common/http";
import {JwtResponse} from "../../models/JwtResponse";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) { }

  authenticateUser(client: UserRegister) {
    return this.httpClient.post<JwtResponse>(authentication,client);
  }
}
