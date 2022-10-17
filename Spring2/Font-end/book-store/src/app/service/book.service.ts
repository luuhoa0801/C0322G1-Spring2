import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Book} from "../model/book";

@Injectable({
  providedIn: 'root'
})
export class BookService {
  API_URL = 'http://localhost:8080/api/public/book';

  constructor(private http: HttpClient) {
  }

  getAll(idCategory: number, search: string): Observable<any> {
    return this.http.get<any>(this.API_URL + '/list?idCategory=' + idCategory + '&name=@');
  }

  getListBook(page: number): Observable<any> {
    return this.http.get<any>(this.API_URL + '/list?page=' +page);
  }

  findById(id: number): Observable<any> {
    return this.http.get<any>(this.API_URL + '/list/show/' + id);
  }

  // getBookDetail(id:number) : Observable<any>{
  //   return this.http.get<any>(this.API_URL +'/show/' + id)
  // }
}
