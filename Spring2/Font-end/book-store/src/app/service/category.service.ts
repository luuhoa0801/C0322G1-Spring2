import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  API_URL = 'http://localhost:8080/api/category';
  constructor(private http: HttpClient) { }
  getAllCateory():Observable<any>{
    return this.http.get<any>(this.API_URL +'/list');
  }

}
