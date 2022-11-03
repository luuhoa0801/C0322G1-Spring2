import {Customer} from "./customer";

export interface AppUser {
  id?: number;
  email?: string;
  username?: string;
  password?: string;
  status?: boolean;
  customer?: Customer;
}
