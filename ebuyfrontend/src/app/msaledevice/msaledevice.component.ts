import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SaleDevice } from '../models/sale-device';
import { SaleDeviceService } from '../services/sale-device.service';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { FileHandle } from '../models/file-handle';

@Component({
  selector: 'app-msaledevice',
  imports: [FormsModule,CommonModule],
  templateUrl: './msaledevice.component.html',
  styleUrl: './msaledevice.component.css'
})
export class MsaledeviceComponent {
saledevice:SaleDevice=new SaleDevice
  submitted = false;
  errordata="";
constructor(private SaleDeviceService:SaleDeviceService ,private router:Router ,private sanitizer:DomSanitizer) { }

  ngOnInit()
  {

  }
  newSaleDevice(): void {
    this.submitted = false;
  this.saledevice = new SaleDevice();
  }

  save() {
    
    this.saledevice.address=localStorage.getItem("address")
    this.saledevice.city=localStorage.getItem("city")
    this.saledevice.state=localStorage.getItem("state")
    const formData=this.prepareFormData(this.saledevice)
    this.SaleDeviceService.createSaleDevice(formData).subscribe(data => {
      if(data!=null)
      {
        alert("Sale added successfully")
      console.log(data)
      this.gotoList();
      }
    }, 
    error =>{ console.log(error);
      this.errordata=error;
     
    })
  }
  prepareFormData(saledevice:SaleDevice):FormData{
    const formData=new FormData()
    formData.append(
      'saledevice',
      new Blob([JSON.stringify(saledevice)],{type:"application/json"})
    );
    for(var i=0;i<saledevice.saleImages.length;i++)
    {
      formData.append(
        'imageFile',
        saledevice.saleImages[i].file,
        saledevice.saleImages[i].file.name
      );
    }
    return formData;
  }
  removeImage(i:number)
  {
    this.saledevice.saleImages.splice(i,1)
  }
  onFileSelected(event:any){
    if(event.target.files)
    {
const file=event.target.files[0];
const fileHandle:FileHandle={
  file:file,
  url:this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(file)),
  name:file.name


}
this.saledevice.saleImages.push(fileHandle)
    }
  }
  onSubmit() {
    this.save();    
    this.submitted = true;
    console.log("inside on submit")
  }

  gotoList() {
    this.router.navigate(["/"]);
  }
}
