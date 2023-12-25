import { Component } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProjectServiceService } from '../project-service.service';
import { Register } from '../models/Register';
import swal from 'sweetalert';
@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css'],
})
export class RegisterUserComponent {
  registrationForm: FormGroup;

  constructor(
    private router: Router,
    private service: ProjectServiceService,
    private fb: FormBuilder
  ) {
    this.registrationForm = this.fb.group(
      {
        nom: ['', [Validators.required]],
        prenom: ['', [Validators.required]],
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(3)]],
        tel: ['', [Validators.required]],
        genre: ['', [Validators.required]],
        privilege: ['', [Validators.required]],
        confirmPassword: ['', [Validators.required, Validators.minLength(3)]],
      },
      { validator: this.passwordMatchValidator }
    );
  }
  passwordMatchValidator(form: FormGroup) {
    return form.get('password')?.value === form.get('confirmPassword')?.value
      ? null
      : { mismatch: true };
  }
  RegisterUser() {
    let register: Register = new Register(
      this.registrationForm.value.nom,
      this.registrationForm.value.prenom,
      this.registrationForm.value.email,
      this.registrationForm.value.tel,
      this.registrationForm.value.password,
      this.registrationForm.value.genre,
      this.registrationForm.value.privilege
    );
    console.log(register);
    if (this.registrationForm.valid) {
      this.service.registerUser(register).subscribe(
        (data) => {
          console.log('Registration successful!');
          const res = data['userRole'];
          localStorage.setItem('_id', data['id']);
          localStorage.setItem('_email', data['userEmail']);
          localStorage.setItem('_role', data['userRole']);
          if (res.toLowerCase() != 'admin') {
            this.router.navigate(['/']);
          } else {
            this.router.navigate(['admin']);
          }
        },
        (error) => {
          console.error('Registration failed:', error);
          swal('Oups', 'Registration failed:', 'error');
        }
      );
    }
  }
}
