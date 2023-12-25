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

  constructor(private service: ProjectServiceService,    private router: Router,
    ) {}

  ngOnInit(): void {}
  addcontact(form: NgForm) {
    let valueofform = form.value;

    {
      let contact = new Reclamation(
        valueofform.nom,
        valueofform.email,
        valueofform.sujet,
        valueofform.message
      );
      this.service.Addcontact(contact).subscribe({
        next: (data) => {
          swal('Done !', 'Your claim has been added!', 'success').finally(()=> this.router.navigate(["/"]));

        },
        error: (err) => {
          swal('Sorry!', 'You need to try later !', 'error');
        },
      });
    }
  }
}
