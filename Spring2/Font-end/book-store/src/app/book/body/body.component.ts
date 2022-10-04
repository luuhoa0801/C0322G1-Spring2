import {Component, OnInit} from '@angular/core';
import {Book} from "../../model/book";
import {BookService} from "../../service/book.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Toast, ToastrService} from "ngx-toastr";
import {TokenStorageService} from "../../service/token-storage.service";
import {ShareService} from "../../service/share.service";

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  bookList: Book[] = [];


  // indexPagination = 0;
  // pages: Array<number>;
  // previousPageStyle = 'inline-block';
  // nextPageStyle = 'inline-block';
  // totalElements = 0;
  // pageSize = 6;
  // displayPagination = 'inline-block';
  // numberOfElement = 0;

  // phan quyen
  username: string;
  idPatient: number;
  currentUser: string;
  role: string;
  isLoggedIn = false;

  constructor(private bookService: BookService,
              private router: Router,
              private activeRouter: ActivatedRoute,
              private toast : ToastrService,
              private tokenStorageService : TokenStorageService,
              private shareService : ShareService) {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadEditAdd();
    });
  }

  ngOnInit(): void {
    this.loadEditAdd();
    this.activeRouter.paramMap.subscribe(param => {
      if (param.get('id') === null && param.get('search') == null) {
        this.bookService.getListBook().subscribe(value => {
          this.bookList = value.content;
        }, error => "lỗi")
        return;
      }
      this.bookService.getAll(+param.get('id'), param.get('search')).subscribe(value => {
        if (value !== null) {
          this.bookList = value.content;
        }
      })
    });

    // this.getListBook();
  }

// phan trang
//   getListBook(size: number) {
//     this.bookService.getListBook(this.pageSize).subscribe((data?: any) => {
//       if (data === null) {
//         this.totalPage = new Array(0);
//         this.bookList = [];
//         this.displayPagination = 'none';
//         this.toast.warning('Không có dữ liệu.', 'Chú ý');
//       } else {
//         this.number = data?.number;
//         this.pageSize = data?.size;
//         this.numberOfElement = data?.numberOfElements;
//         this.bookList = data.content;
//         this.totalElements = data?.totalElements;
//         this.totalPage = new Array(data?.totalPages);
//       }
//       this.checkPreviousAndNext();
//       this.isCheckedAll();
//     }, error1 => {
//       this.bookList = null;
//     });
//   }

  // previousPage(event: any) {
  //   event.preventDefault();
  //   this.indexPagination--;
  //   this.ngOnInit();
  // }

  // nextPage(event: any) {
  //   event.preventDefault();
  //   this.indexPagination++;
  //   this.ngOnInit();
  // }

  // checkPreviousAndNext() {
  //   if (this.indexPagination === 0) {
  //     this.previousPageStyle = 'none';
  //   } else if (this.indexPagination !== 0) {
  //     this.previousPageStyle = 'inline-block';
  //   }
  //   if (this.indexPagination < (this.totalPage.length - 1)) {
  //     this.nextPageStyle = 'inline-block';
  //   } else if (this.indexPagination === (this.totalPage.length - 1) || this.indexPagination > (this.totalPage.length - 1)) {
  //     this.nextPageStyle = 'none';
  //   }
  // }

  // isCheckedAll() {
  //   const listDeleted = this.deleteList.filter((item) => this.bookList.some(item2 => item.id === item2.id));
  //   const lengthDeleted = listDeleted.filter(
  //     (exporter, index) => index === listDeleted.findIndex(
  //       other => exporter.id === other.id
  //     )).length;
  //   this.checkAll = lengthDeleted === this.bookList.length;
  // }

  // phanquyen
  loadEditAdd(): void {
    if (this.tokenStorageService.getToken()) {
      this.currentUser = this.tokenStorageService.getUser().username;
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
    }
    this.isLoggedIn = this.username != null;
  }

}
