import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { LoginComponent } from './login/login.component';

import { AdminLoginComponent } from './admin-login/admin-login.component';
import { ViewFeedbackComponent } from './view-feedback/view-feedback.component';
import { ViewRegisterComponent } from './view-register/view-register.component';
import { MsalecarComponent } from './msalecar/msalecar.component';
import { CategoriesComponent } from './categories/categories.component';
import { Component } from '@angular/core';
import { CarsComponent } from './cars/cars.component';
import { BuyComponent } from './buy/buy.component';
import { MsaledeviceComponent } from './msaledevice/msaledevice.component';
import { MsaleotherComponent } from './msaleother/msaleother.component';
import { DevicesComponent } from './devices/devices.component';
import { OthersComponent } from './others/others.component';

export const routes: Routes = [
    {path:'',component:HomeComponent},
    {path:'feedback',component:FeedbackComponent},
    {path:'register',component:RegisterComponent},
    {path:'login',component:LoginComponent},
    {path:'admin-login',component:AdminLoginComponent},
    {path:'vfeedback',component:ViewFeedbackComponent},
    {path:'vreg',component:ViewRegisterComponent},
    {path:'msalecar',component:MsalecarComponent},
    {path:'msaledevice',component:MsaledeviceComponent},
    {path:'msaleother',component:MsaleotherComponent},
    {path:'categories',component:CategoriesComponent},
    {path:'cars',component:CarsComponent},
    {path:'devices',component:DevicesComponent},
    {path:'others',component:OthersComponent},
    {path:'buy/:scid',component:BuyComponent},
    {path:'buy/:sdid',component:BuyComponent},
    {path:'buy/:soid',component:BuyComponent}
];
