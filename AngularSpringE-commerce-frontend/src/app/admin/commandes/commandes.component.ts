import { Component } from '@angular/core';
import { ProjectServiceService } from 'src/app/project-service.service';

@Component({
  selector: 'app-commandes',
  templateUrl: './commandes.component.html',
  styleUrls: ['./commandes.component.css'],
})
export class CommandesComponent {
  commandes: any[] = [];
  constructor(private service: ProjectServiceService) {}
  ngOnInit(): void {
    this.fetchReclamations();
  }

  fetchReclamations(): void {
    this.service.getAllCommandes().subscribe((cmds) => {
      this.commandes = cmds;
      console.log(cmds);
    });
  }
  updateStatus(idorder: number, initStatus: string) {
    let newStatus = '';
    if (initStatus == 'accepted') {
      newStatus = 'not approved';
    } else {
      newStatus = 'accepted';
    }
    this.service.updateCommandeStatus(idorder, newStatus).subscribe((res) => {
      if (res != null) {
        this.fetchReclamations();
      }
    });
  }
}
