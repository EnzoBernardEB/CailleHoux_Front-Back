import { Injectable } from '@angular/core';
import {User} from "../../models/User";
import {UserHttpService} from "./user-http.service";
import {UserRegister} from "../../models/UserRegister";
import {JwtResponse} from "../../models/JwtResponse";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  activeUser: User;
  constructor() { }


}
