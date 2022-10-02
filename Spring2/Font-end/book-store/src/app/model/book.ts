import {Category} from "./category";

export interface Book {
  id?: number;
  code?:string;
  name?:string;
  price?:number;
  discount?:number;
  author?:string;
  description?:string;
  dimension?:string;
  translator?:string;
  publishingHome?:string;
  img?:string;
  quantity?:string;
  totalPage?:number;
  releaseDate?:string;
  category?: Category;
}

