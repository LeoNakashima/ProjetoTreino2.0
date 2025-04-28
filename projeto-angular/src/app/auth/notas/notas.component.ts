import { Component, HostListener } from '@angular/core';
import { Router } from '@angular/router';
import { HeaderComponent } from "../../layout/header/header.component";
import { SidebarComponent } from "../../layout/sidebar/sidebar.component";

@Component({
  selector: 'app-notas',
  imports: [HeaderComponent, SidebarComponent],
  templateUrl: './notas.component.html',
  styleUrl: './notas.component.css'
})
export class NotasComponent {
  constructor(private router: Router) {}


  fazerCadastro() {
    this.router.navigate(['cadastro-notas']);
  }

  
  menuAberto = false;

  abrirMenu() {
    this.menuAberto = !this.menuAberto;
  }

  remover() {
    this.menuAberto = false;
    // lógica de remoção
  }

  editar() {
    this.menuAberto = false;
    // lógica de edição
  }

  
}
