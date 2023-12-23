import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllvitrineComponent } from './vitrine/allvitrine/allvitrine.component';
import { LoginComponent } from './login/login.component';
import { ErrorPathRoutingComponent } from './error-path-routing/error-path-routing.component';
import { AdminpanelComponent } from './admin/adminpanel/adminpanel.component';
import { AddproductComponent } from './admin/addproduct/addproduct.component';
import { ShowproductComponent } from './admin/showproduct/showproduct.component';
import { UpdateproductComponent } from './admin/updateproduct/updateproduct.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { SmartphoneComponent } from './smartphone/smartphone.component';
import { MobileComponent } from './mobile/mobile.component';
import { ContactComponent } from './contact/contact.component';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { ShowuserComponent } from './admin/showuser/showuser.component';
const routes: Routes = [
  {path:"vitrine",redirectTo:'/',pathMatch:'full'},
  {path:"",component:AllvitrineComponent},
  {path:"login",component:LoginComponent},
{path:"register",component:RegisterUserComponent},
{path:"smartphone",component:SmartphoneComponent},
{path:"mobile",component:MobileComponent},
{path:"contact",component:ContactComponent},
{path:"cart",component:CartComponent},
{path:"checkout",component:CheckoutComponent},

  {path:"admin",component:AdminpanelComponent,children:
    [
      {path:"addproduct",component:AddproductComponent},
      {path:"showproduct",component:ShowproductComponent},
      {path:"showuser",component:ShowuserComponent},
      {path:"updateproduct/:id",component:UpdateproductComponent},
      

    ]},
  {path:"**",component:ErrorPathRoutingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
