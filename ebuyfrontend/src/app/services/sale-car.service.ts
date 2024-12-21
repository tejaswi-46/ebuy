import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SaleCar } from '../models/sale-car';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SaleCarService {
  private baseUrl = 'http://localhost:9009/salecar/salecars';

  constructor(private http:HttpClient) { }
 

  createSaleCar(salecar:FormData): Observable<Object> {
   
    return this.http.post(`${this.baseUrl}`, salecar);
  }
  getAll() {
   
    return this.http.get<SaleCar[]>(`${this.baseUrl}`);
  }
  deleteSaleCar(scid:number){
   
    return this.http.delete(`${this.baseUrl}`+"/"+scid)
  }
}
