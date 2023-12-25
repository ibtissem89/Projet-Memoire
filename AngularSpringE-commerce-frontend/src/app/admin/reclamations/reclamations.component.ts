import { Component } from '@angular/core';
import { ProjectServiceService } from 'src/app/project-service.service';

@Component({
  selector: 'app-reclamations',
  templateUrl: './reclamations.component.html',
  styleUrls: ['./reclamations.component.css']
})
export class ReclamationsComponent {
  reclamations: any[] = [];

  constructor(private service: ProjectServiceService) {}

  ngOnInit(): void {
    this.fetchReclamations();
  }

  fetchReclamations(): void {
    this.service.getAllReclamation().subscribe((reclamations) => {
      this.reclamations = reclamations;
      console.log(reclamations);
      
    });
  }
}
