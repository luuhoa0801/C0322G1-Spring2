import {Customer} from "./customer";

export interface AppUser {
  id?: number;
  username?: string;
  password?: string;
  status?: boolean;
  customer?: Customer;
}
