import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { LoginComponent } from './login/login.component';

import { AdminLoginComponent } from './admin-login/admin-login.component';
import { ViewFeedbackComponent } from './view-feedback/view-feedback.component';
import { ViewRegisterComponent } from './view-register/view-register.component';

export const routes: Routes = [
    {path:'',component:HomeComponent},
    {path:'feedback',component:FeedbackComponent},
    {path:'register',component:RegisterComponent},
    {path:'login',component:LoginComponent},
    {path:'admin-login',component:AdminLoginComponent},
    {path:'vfeedback',component:ViewFeedbackComponent},
    {path:'vreg',component:ViewRegisterComponent}
];
