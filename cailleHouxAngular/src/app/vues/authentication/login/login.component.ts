import {Component, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {UserRegister} from "../../../models/UserRegister";
import {AuthenticationService} from "../../../service/authentication/authentication.service";
import {UserService} from "../../../service/user/user.service";
import {JwtResponse} from "../../../models/JwtResponse";
import {RedirectionService} from "../../../service/app/redirection.service";

@Component({
  selector: 'chx-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  @ViewChild("form") form!: NgForm;
  client: UserRegister = {username:"",password:""};

  constructor(
    private authService: AuthenticationService,
    private userService: UserService,
    private redirectionService: RedirectionService
    ) { }

  authenticateUser() {
    this.authService.authenticateUser(this.client).subscribe({
      next: (jwtResponse:JwtResponse) => {
        this.connecter(jwtResponse.accessToken);
      },
      complete: () => this.redirectionService.redirectionProducts()
    });
  }

  public connecter(token: string) {
    localStorage.setItem('Access_token',token);
  }

  public estConnecte() {
    return localStorage.getItem('Access_token') !== null;
  }

  public deconnecter() {
    localStorage.removeItem('Access_token');
  }

}
