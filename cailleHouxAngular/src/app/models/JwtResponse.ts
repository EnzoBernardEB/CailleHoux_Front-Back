export interface JwtResponse {
  accessToken:string;
  username:string;
  email:string
  id:number;
  roles:Array<string>;
  tokenType:string;
}
