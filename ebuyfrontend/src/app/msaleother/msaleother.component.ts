import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { FileHandle } from '../models/file-handle';
import { SaleCar } from '../models/sale-car';
import { SaleOther } from '../models/sale-other';
import { SaleOtherService } from '../services/sale-other.service';

@Component({
  selector: 'app-msaleother',
  imports: [FormsModule,CommonModule],
  templateUrl: './msaleother.component.html',
  styleUrl: './msaleother.component.css'
})
export class MsaleotherComponent {

  saleother:SaleOther=new SaleOther
    submitted = false;
    errordata="";
  constructor(private SaleOtherService:SaleOtherService ,private router:Router,private sanitizer:DomSanitizer) { }
  
    ngOnInit()
    {
  
    }
    newSaleCar(): void {
      this.submitted = false;
    this.saleother = new SaleOther();
    }
  
    save() {
      
      this.saleother.address=localStorage.getItem("address")
      this.saleother.city=localStorage.getItem("city")
      this.saleother.state=localStorage.getItem("state")
      const formData=this.prepareFormData(this.saleother);
      this.SaleOtherService.createSaleOther(formData).subscribe(data => {
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
    prepareFormData(saleother:SaleOther):FormData{
      const formData=new FormData()
      formData.append(
        'saleother',
        new Blob([JSON.stringify(saleother)],{type:"application/json"})
      );
      for(var i=0;i<saleother.saleImages.length;i++)
      {
        formData.append(
          'imageFile',
          saleother.saleImages[i].file,
          saleother.saleImages[i].file.name
        );
      }
      return formData;
    }
    removeImage(i:number)
    {
      this.saleother.saleImages.splice(i,1)
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
  this.saleother.saleImages.push(fileHandle)
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
