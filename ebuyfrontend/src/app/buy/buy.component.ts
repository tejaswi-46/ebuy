import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Buy } from '../models/buy';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { BuyService } from '../services/buy.service';
import { SaleCar } from '../models/sale-car';

@Component({
  selector: 'app-buy',
  imports: [CommonModule,FormsModule,ReactiveFormsModule],
  templateUrl: './buy.component.html',
  styleUrl: './buy.component.css'
})
export class BuyComponent implements OnInit{
  
  grp: FormGroup
 id:any
  buy:Buy=new Buy()

  constructor(private fb:FormBuilder, private buyserv:BuyService,private route:ActivatedRoute)
  {
    this.grp=this.fb.group({
      
      pin:['',[Validators.required]],
      prod:['',[Validators.required]],
      pmethod:['',[Validators.required]],
      
    })

  }
  ngOnInit(): void {
  
    this.id=this.route.snapshot.params['scid']
   
    
  }
   
    
    get f():any{
      return this.grp.controls;
    }
    get pin():any
    {
      return this.grp.get('pin')
    }
    get prod():any
    {
      return this.grp.get('prod')
    }
    get pmethod():any
    {
      return this.grp.get('pmethod')
    }
   
    
    submitdata(){
      if(this.grp.valid)
      {
  
        this.buy.name=localStorage.getItem("name")
        this.buy.email=localStorage.getItem("email")
        this.buy.contact=localStorage.getItem("contact")
        this.buy.address=localStorage.getItem("address")
        this.buy.city=localStorage.getItem("city")
        this.buy.state=localStorage.getItem("state")
      
        this.buyserv.buysave(this.buy).subscribe(data=>{
          alert('Your request has been submitted')
         
        })
        
      }
      else{
        alert('Your request could not be processed')
      }
    }
}
