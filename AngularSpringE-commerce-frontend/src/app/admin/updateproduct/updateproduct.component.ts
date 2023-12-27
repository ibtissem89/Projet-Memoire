import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Addproduct } from 'src/app/models/Addproduct';
import { ProjectServiceService } from 'src/app/project-service.service';
import swal from 'sweetalert';
@Component({
  selector: 'app-updateproduct',
  templateUrl: './updateproduct.component.html',
  styleUrls: [
    './updateproduct.component.css',
    '../../../assets/css/demo.css',
    '../../../assets/css/wizard.css',
  ],
})
export class UpdateproductComponent implements OnInit {
  productbyid: any;
  filebase64: any = '';
  categories: any[] = [];
  constructor(
    private activatedRoute: ActivatedRoute,
    private service: ProjectServiceService
  ) {}

  ngOnInit(): void {
    //getting categories list
    this.service.getallCategorys().subscribe((data) => {
      this.categories = data;
    });
    this.activatedRoute.params.subscribe({
      next: (data) => {
        this.service.geproductbyid(data['id']).subscribe({
          next: (data) => {
            this.productbyid = data;
          },
          error: (err) => {
            console.log(err);
          },
        });
      },
      error: (err) => {},
    });
  }

  updateproduct(form: any) {
    this.productbyid.type = this.productbyid.category.name.toString();
    delete this.productbyid.category;
    console.log(this.productbyid);
    
    this.service.updateproduct(this.productbyid).subscribe({
      next: (data) => {
        swal('Bien  !', 'Votre produit a été mis à jour !', 'success');
      },
      error: (err) => {
        swal('Désolé !', 'Vous devez réessayer plus tard !', 'error');
      },
    });
  }


  getfile(event: any) {
    const file = event.target.files[0];

    if (file) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        const base64Image = e.target.result;
        this.productbyid.image = base64Image.slice(
          base64Image.indexOf(',') + 1
        );
      };
      reader.readAsDataURL(file);
    }
  }
}
