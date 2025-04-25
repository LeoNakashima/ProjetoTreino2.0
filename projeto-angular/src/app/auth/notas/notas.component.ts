import { Component } from '@angular/core';
import { HeaderComponent } from '../../layout/header/header.component';
import { SidebarComponent } from '../../layout/sidebar/sidebar.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-notas',
  imports: [HeaderComponent, SidebarComponent],
  templateUrl: './notas.component.html',
  styleUrl: './notas.component.css'
})
export class NotasComponent {
  constructor(private router: Router) {}
  fazerCadastro() {
    this.router.navigate(['cadastrarAluno']);
  }
}
