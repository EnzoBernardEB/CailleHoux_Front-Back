import {Role} from "./Role.enum";

export interface User {
  id:number;
  username:string;
  role: Role;
}
