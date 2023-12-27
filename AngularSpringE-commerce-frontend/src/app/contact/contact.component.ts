import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Reclamation } from 'src/app/models/Reclamation';
import { ProjectServiceService } from 'src/app/project-service.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css'],
})
export class ContactComponent implements OnInit {
  message: any = '';

  constructor(private service: ProjectServiceService, private router: Router) {}

  ngOnInit(): void {}
  addcontact(form: NgForm) {
    let formValues = form.value;

    {
      let reclamation = new Reclamation(
        formValues.nom,
        formValues.email,
        formValues.sujet,
        formValues.message
      );
      this.service.addReclamation(reclamation).subscribe({
        next: (data) => {
          swal(
            'Terminé !',
            'Votre réclamation a été ajoutée !',
            'success'
          ).finally(() => this.router.navigate(['/']));
        },
        error: (err) => {
          swal('Désolé !', 'Veuillez réessayer plus tard !', 'error');
        },
      });
    }
  }
}
