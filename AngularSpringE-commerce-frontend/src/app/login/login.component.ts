import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ProjectServiceService } from '../project-service.service';
import { UserLogin } from '../models/UserLogin';
import swal from 'sweetalert';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private router : Router, private service : ProjectServiceService)
  {

  }
  Login(formlogin:NgForm)
  {
    let userlogin : UserLogin = new UserLogin(formlogin.value.username,formlogin.value.password);
    console.log(userlogin);

    this.service.loginUser(userlogin).subscribe(
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


