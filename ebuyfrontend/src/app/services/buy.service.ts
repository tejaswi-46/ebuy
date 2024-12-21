import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Buy } from '../models/buy';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BuyService {
private serverurl="http://localhost:9009/buy"
  constructor(private http:HttpClient) { }

  buysave(b:Buy):Observable<Buy>
  {
    return this.http.post<Buy>(this.serverurl+"/addbuy",b)
  }
  getallbuy():Observable<Buy[]>
  {
    return this.http.get<Buy[]>(this.serverurl+"/buys")
  }

}
