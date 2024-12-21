import { Component } from '@angular/core'
import { SaleCar } from '../models/sale-car'
import { SaleCarService } from '../services/sale-car.service';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { FileHandle } from '../models/file-handle';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-msalecar',
  imports: [FormsModule,CommonModule],
  standalone:true,
  templateUrl: './msalecar.component.html',
  styleUrl: './msalecar.component.css'
})
export class MsalecarComponent {
  salecar:SaleCar=new SaleCar
  submitted = false;
  errordata="";
constructor(private SaleCarService:SaleCarService,private router:Router,private sanitizer:DomSanitizer) { }

  ngOnInit()
  {

  }
  newSaleCar(): void {
    this.submitted = false;
  this.salecar = new SaleCar();
  }

  save() {
    
    this.salecar.address=localStorage.getItem("address")
    this.salecar.city=localStorage.getItem("city")
    this.salecar.state=localStorage.getItem("state")
    const formData=this.prepareFormData(this.salecar);
    this.SaleCarService.createSaleCar(formData).subscribe(data => {
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
  prepareFormData(salecar:SaleCar):FormData{
    const formData=new FormData()
    formData.append(
      'salecar',
      new Blob([JSON.stringify(salecar)],{type:"application/json"})
    );
    for(var i=0;i<salecar.saleImages.length;i++)
    {
      formData.append(
        'imageFile',
        salecar.saleImages[i].file,
        salecar.saleImages[i].file.name
      );
    }
    return formData;
  }
  removeImage(i:number)
  {
    this.salecar.saleImages.splice(i,1)
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
this.salecar.saleImages.push(fileHandle)
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
