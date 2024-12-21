import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SaleDevice } from '../models/sale-device';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SaleDeviceService {
  private baseUrl = 'http://localhost:9009/saledevice/saledevices';

  constructor(private http:HttpClient) { }
 

  createSaleDevice(saledevice:FormData): Observable<Object> {
   
    return this.http.post(`${this.baseUrl}`, saledevice);
  }
  getAll() {
   
    return this.http.get<SaleDevice[]>(`${this.baseUrl}`);
  }
  deleteSaleDevice(sdid:number){
   
    return this.http.delete(`${this.baseUrl}`+"/"+sdid)
  }
}
