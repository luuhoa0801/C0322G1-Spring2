import { NgModule } from '@angular/core';
import {CommonModule, DatePipe} from '@angular/common';

import { ChatRoutingModule } from './chat-routing.module';
import {AddroomComponent} from "./addroom/addroom.component";
import {ChatroomComponent} from "./chatroom/chatroom.component";
import {RoomlistComponent} from "./roomlist/roomlist.component";
import { LoginroomComponent } from './loginroom/loginroom.component';
import {MatInputModule} from "@angular/material/input";
import {MatIconModule} from "@angular/material/icon";
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatTableModule} from "@angular/material/table";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {MatSortModule} from "@angular/material/sort";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MatSidenavModule} from "@angular/material/sidenav";
import {ReactiveFormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";


@NgModule({
  declarations: [AddroomComponent,ChatroomComponent,RoomlistComponent, LoginroomComponent],
  imports: [
    CommonModule,
    ChatRoutingModule,

    MatInputModule,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    MatTableModule,
    MatProgressSpinnerModule,
    MatSortModule,
    MatSnackBarModule,
    MatSidenavModule,
    ReactiveFormsModule,
    MatButtonModule
  ],
  providers: [DatePipe],
})
export class ChatModule { }
