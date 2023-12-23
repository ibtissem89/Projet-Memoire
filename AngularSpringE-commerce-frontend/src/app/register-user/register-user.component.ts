
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ProjectServiceService } from '../project-service.service';
import { Register } from '../models/Register';
import swal from 'sweetalert';
@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent{




  constructor(private router : Router, private service : ProjectServiceService)
  {

  }
 RegisterUser(formregister:NgForm)
  {
    let register : Register= new Register(formregister.value.nom,formregister.value.prénom,formregister.value.tél,formregister.value.mpass,formregister.value.cpass,formregister.value.genre,formregister.value.privilége);
    console.log(register);

    this.service.registerUser(register).subscribe(
      {
      next:(data)=>
      { 
        this.router.navigate(["admin"]);
      },
      error:(error)=>
      {
        swal("Oups", "Username or password wrong", "error");
      }
      }
    )


    
  }

}

