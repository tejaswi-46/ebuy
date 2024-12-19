import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-navbar',
  imports: [RouterLink,CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit{

menutype="guest"
constructor(private router:Router)
{

}
ngOnInit(): void {
  this.router.events.subscribe((val:any)=>{
    if(val.url)
    {
      let mt=localStorage.getItem("menutype")
      if(mt=="user")
      {
        this.menutype="user"
      }
      else if(mt=="admin"){
        this.menutype="admin"
      }
      else{
        this.menutype="guest"
      }
    }
  })
}
logout(){
  localStorage.removeItem("email")
  localStorage.setItem("menutype","guest")
  this.router.navigate(["/"])
}
alogout()
{
  localStorage.setItem("menutype","guest")
  this.router.navigate(["/"])
}


}
