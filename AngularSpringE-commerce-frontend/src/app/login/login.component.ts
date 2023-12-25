import { Component } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProjectServiceService } from '../project-service.service';
import { UserLogin } from '../models/UserLogin';
import swal from 'sweetalert';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  loginForm: FormGroup;
  constructor(
    private router: Router,
    private service: ProjectServiceService,
    private fb: FormBuilder
  ) {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]], //Validators.email
      password: ['', [Validators.required, Validators.minLength(3)]],
    });
  }
   Login() {
    if (this.loginForm.valid) {
      let userlogin: UserLogin = new UserLogin(
        this.loginForm.value.username,
        this.loginForm.value.password
      );
      console.log(userlogin);

      this.service.loginUser(userlogin).subscribe({
        next: (data) => {
          // save user email and ID localstorage
          localStorage.setItem('_id', data["id"]);
          localStorage.setItem('_email', data["userEmail"]);
          localStorage.setItem('_role', data['userRole']);
          const userRole: String = data['userRole'];
          if (userRole.toLowerCase() == 'admin') {
            this.router.navigate(['admin']);
          } else {
            this.router.navigate(['/']);
          }
        },
        error: (error) => {
          swal('Oups', 'Username or password wrong', 'error');
        },
      });
    }
  }
}
