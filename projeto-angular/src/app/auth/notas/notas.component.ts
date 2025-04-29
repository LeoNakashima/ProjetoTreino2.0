import { Component } from '@angular/core';
import { HeaderComponent } from '../../layout/header/header.component';
import { SidebarComponent } from '../../layout/sidebar/sidebar.component';
import { Router } from '@angular/router';
import { NgIf } from '@angular/common';
import { EditarComponent } from '../../layout/editar/editar.component';

@Component({
  selector: 'app-notas',
  imports: [HeaderComponent, SidebarComponent, EditarComponent, NgIf],
  templateUrl: './notas.component.html',
  styleUrl: './notas.component.css'
})
export class NotasComponent {
  constructor(private router: Router) {}

  validaCadastro = true;

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

  remover(){
    

  }

  editar(){

  }


  


}
