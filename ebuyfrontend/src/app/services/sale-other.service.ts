import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SaleOther } from '../models/sale-other';

@Injectable({
  providedIn: 'root'
})
export class SaleOtherService {
  private baseUrl = 'http://localhost:9009/saleother/saleothers';

  constructor(private http:HttpClient) { }
 

  createSaleOther(saleother:FormData): Observable<Object> {
   
    return this.http.post(`${this.baseUrl}`, saleother);
  }
  getAll() {
   
    return this.http.get<SaleOther[]>(`${this.baseUrl}`);
  }
  deleteSaleOther(soid:number){
   
    return this.http.delete(`${this.baseUrl}`+"/"+soid)
  }
}
