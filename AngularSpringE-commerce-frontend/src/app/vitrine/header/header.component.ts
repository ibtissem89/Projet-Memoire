import { Component } from '@angular/core';
import { ProjectServiceService } from 'src/app/project-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {
  isLoged: boolean = false;
  useremail: String = '';
  nbItemCarte: number = -1;

  constructor(private service: ProjectServiceService) {}
  ngOnInit() {
    const storedEmail = localStorage.getItem('_email');
    const iduser = localStorage.getItem('_id');

    if (storedEmail !== null && storedEmail !== undefined) {
      this.useremail = storedEmail.toString();
      this.isLoged = true;
      this.service.getCartItems(Number(iduser)).subscribe((items) => {
        if (items != null) {
          let tempTab: any[] = items as any[];
          console.log(items);
          
          this.nbItemCarte = tempTab.length;
        }
      });
      this.nbItemCarte = 0;
    } else {
      this.isLoged = false;
    }
  }
  deconnexion() {
    localStorage.clear();
  }
}
