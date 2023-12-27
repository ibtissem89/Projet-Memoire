import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Addproduct } from 'src/app/models/Addproduct';
import { ProjectServiceService } from 'src/app/project-service.service';
import swal from 'sweetalert';
@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css'],
})
export class AddproductComponent {
  filebase64: any = '';
  categories: any[] = [];
  constructor(private service: ProjectServiceService) {}
  ngOnInit() {
    //getting categories list
    this.service.getallCategorys().subscribe((data) => {
      this.categories = data;
    });
  }
  addproduct(form: NgForm) {
    let valueofform = form.value;
    if (this.filebase64 != '') {
      let product = new Addproduct(
        valueofform.name,
        valueofform.description,
        valueofform.prix,
        valueofform.type,
        this.filebase64
      );
      this.service.addproduct(product).subscribe({
        next: (data) => {
          swal('Good job!', 'Your product has been added!', 'success');
        },
        error: (err) => {
          swal('Sorry!', 'You need to try later !', 'error');
        },
      });
    }
  }
  getfile(event: any) {
    const file = event.target.files[0];

    if (file) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        const base64Image = e.target.result;
        this.filebase64 = base64Image.slice(base64Image.indexOf(',') + 1);
      };
      reader.readAsDataURL(file);
    }
  }
}
