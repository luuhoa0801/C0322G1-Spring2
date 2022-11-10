import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TopBookRoutingModule } from './top-book-routing.module';
import {TopBookComponent} from "./top-book.component";
import {ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatSelectModule} from "@angular/material/select";


@NgModule({
  declarations: [TopBookComponent],
  imports: [
    CommonModule,
    TopBookRoutingModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule
  ]
})
export class TopBookModule { }
