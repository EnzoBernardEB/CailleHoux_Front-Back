import { Component, OnInit } from '@angular/core';
import {UserHttpService} from "../../../service/user/user-http.service";
import {User} from "../../../models/User";
import {UserService} from "../../../service/user/user.service";

@Component({
  selector: 'chx-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  get user(): User|null {
    return this.userService.activeUser;
  }
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

}
