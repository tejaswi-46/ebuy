import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SaleDevice } from '../models/sale-device';
import { SaleDeviceService } from '../services/sale-device.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-devices',
  imports: [FormsModule,CommonModule],
  templateUrl: './devices.component.html',
  styleUrl: './devices.component.css'
})
export class DevicesComponent {

   devices:SaleDevice[]=[]
    login=false
   constructor(private SaleDeviceService:SaleDeviceService ,private router:Router){
  
   }
   getAllDevices()
   {
  
     this.SaleDeviceService.getAll().subscribe((response:SaleDevice[])=>{
       console.log(response)
       this.devices=response
     },
     
     (error:HttpErrorResponse)=>{
       console.log(error)
      });
   }
   ngOnInit(): void {
     this.getAllDevices()
     console.log(localStorage.getItem("email"))
     if(localStorage.getItem("email")!=null)
      this.login=true
   }
  
  buy(sdid:any)
  {
  this.router.navigate(["/buy",sdid])
  
  }
}
