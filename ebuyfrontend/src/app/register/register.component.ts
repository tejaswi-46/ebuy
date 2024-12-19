import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder,FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Registration } from '../models/registration';
import { RegistrationService } from '../services/registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [ReactiveFormsModule, CommonModule, FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  reg:Registration=new Registration()
  grp: FormGroup
  constructor(private fb:FormBuilder, private regserv:RegistrationService)
  {
    this.grp=this.fb.group({
      name:['',[Validators.required,Validators.pattern("^[a-zA-Z]+$")]],
      contact:['',[Validators.required,Validators.pattern("[0-9]{10}")]],
      email:['',[Validators.required,Validators.email]],
      password:['',[Validators.required,Validators.pattern("[a-zA-Z0-9#$@!]{8,16}")]],
      address:['',[Validators.required]],
      city:['',[Validators.required]],
      state:['',[Validators.required]]
    })
  }
  get f():any{
    return this.grp.controls;
  }
  get name():any
  {
    return this.grp.get('name')
  }
  get contact():any
  {
    return this.grp.get('contact')
  }
  get email():any
  {
    return this.grp.get('email')
  }
  get password():any
  {
    return this.grp.get('password')
  }
  get address():any
  {
    return this.grp.get('address')
  }
  get city():any
  {
    return this.grp.get('city')
  }
  get state():any
  {
    return this.grp.get('state')
  }
  
  submitdata(){
    if(this.grp.valid)
    {

      this.regserv.save(this.reg).subscribe(data=>{
        alert('Registration successful')
       
      })
      
    }
    else{
      alert('problem occured')
    }
  }
}
