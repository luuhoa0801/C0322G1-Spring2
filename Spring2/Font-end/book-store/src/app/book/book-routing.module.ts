import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BodyComponent} from "./body/body.component";
import {BookDetailComponent} from "./book-detail/book-detail.component";


const routes: Routes = [
  // { path: 'book/list/:id/:search',
  //   component: BodyComponent
  // },
  { path: 'list/:id/:search',
    component: BodyComponent
  },
  { path: 'list',
    component: BodyComponent
  },
  { path: 'show/:id',
    component: BookDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule { }
