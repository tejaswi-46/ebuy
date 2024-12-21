import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SaleCarService } from '../services/sale-car.service';
import { SaleCar } from '../models/sale-car';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cars',
  imports: [FormsModule,CommonModule],
  templateUrl: './cars.component.html',
  styleUrl: './cars.component.css'
})
export class CarsComponent {
  cars:SaleCar[]=[]
  login=false
 constructor(private salecarService:SaleCarService,private router:Router){

 }
 getAllCars()
 {

   this.salecarService.getAll().subscribe((response:SaleCar[])=>{
     console.log(response)
     this.cars=response
   },
   
   (error:HttpErrorResponse)=>{
     console.log(error)
    });
 }
 ngOnInit(): void {
   this.getAllCars()
   console.log(localStorage.getItem("email"))
   if(localStorage.getItem("email")!=null)
    this.login=true
 }

buy(scid:any)
{
this.router.navigate(["/buy",scid])

}
}
