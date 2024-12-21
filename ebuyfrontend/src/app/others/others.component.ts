import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SaleOther } from '../models/sale-other';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { SaleCar } from '../models/sale-car';
import { SaleOtherService } from '../services/sale-other.service';

@Component({
  selector: 'app-others',
  imports: [FormsModule,CommonModule],
  templateUrl: './others.component.html',
  styleUrl: './others.component.css'
})
export class OthersComponent {

   others:SaleOther[]=[]
    login=false
   constructor(private saleotherService:SaleOtherService,private router:Router){
  
   }
   getAllOthers()
   {
  
     this.saleotherService.getAll().subscribe((response:SaleOther[])=>{
       console.log(response)
       this.others=response
     },
     
     (error:HttpErrorResponse)=>{
       console.log(error)
      });
   }
   ngOnInit(): void {
     this.getAllOthers()
     console.log(localStorage.getItem("email"))
     if(localStorage.getItem("email")!=null)
      this.login=true
   }
  
  buy(soid:any)
  {
  this.router.navigate(["/buy",soid])
  
  }
}
