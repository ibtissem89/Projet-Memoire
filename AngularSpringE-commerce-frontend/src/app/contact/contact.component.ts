import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Addcontact } from 'src/app/models/Addcontact';
import { ProjectServiceService } from 'src/app/project-service.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']

})
export class ContactComponent  implements OnInit{

  message : any="";

  constructor(private service : ProjectServiceService) { }

  ngOnInit(): void {
  }
  addcontact(form:NgForm)
  {
   
    let valueofform = form.value;
   
    {
    let contact = new Addcontact(valueofform.nom,valueofform.email,valueofform.sujet,valueofform.message);
    this.service.Addcontact(contact).subscribe(
      {
        next:(data)=>
        {
          swal("Good job!", "Your product has been added!", "success");
        },
        error:(err)=>
        {
          swal("Sorry!", "You need to try later !", "error");
        }
      }
    )
  }
}}
