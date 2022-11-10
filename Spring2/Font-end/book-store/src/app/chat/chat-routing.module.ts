import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AddroomComponent} from "./addroom/addroom.component";
import {RoomlistComponent} from "./roomlist/roomlist.component";
import {LoginroomComponent} from "./loginroom/loginroom.component";
import {ChatroomComponent} from "./chatroom/chatroom.component";


const routes: Routes = [
  { path: 'addroom', component: AddroomComponent },
  { path: 'roomlist', component: RoomlistComponent },
  { path: 'loginroom', component: LoginroomComponent},
  { path: 'chatroom/:roomname', component: ChatroomComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ChatRoutingModule { }
