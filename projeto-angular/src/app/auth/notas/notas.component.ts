import { Component, HostListener } from '@angular/core';
import { Router } from '@angular/router';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-notas',
  imports: [HeaderComponent, SidebarComponent, NgIf],
  templateUrl: './notas.component.html',
  styleUrl: './notas.component.css'
})
export class NotasComponent {
  constructor(private router: Router) {}


  fazerCadastro() {
    this.router.navigate(['cadastro-notas']);
  }

  
  menuAberto = false;

  abrirMenu(){
    this.menuAberto =! this.menuAberto
  }
  fecharMenu(){
    this.menuAberto = false
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
