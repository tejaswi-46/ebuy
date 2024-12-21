import { Component } from '@angular/core';
import { Registration } from '../models/registration';
import { RegistrationService } from '../services/registration.service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
reg:Registration=new Registration()
constructor(private regserv:RegistrationService,private router:Router)
{

}
submitdata()
{
  this.regserv.login(this.reg.email,this.reg.password).subscribe(data=>{
    if(data.length>0)
    {
      alert("login successful")
      let ro=data[0]
      localStorage.setItem("email",this.reg.email)
      localStorage.setItem("menutype","user")
      localStorage.setItem("name",ro.name)
      localStorage.setItem("address",ro.address)
      localStorage.setItem("city",ro.city)
      localStorage.setItem("state",ro.state)
      this.router.navigate(["/"])
    }
    else
    {
      alert("Invalid email or password")
    }
  })
}
}
