import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookRoutingModule } from './book-routing.module';
import {BodyComponent} from "./body/body.component";
import {BookDetailComponent} from "./book-detail/book-detail.component";
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [BodyComponent,BookDetailComponent],
  imports: [
    CommonModule,
    BookRoutingModule,
    ReactiveFormsModule
  ]
})
export class BookModule { }
