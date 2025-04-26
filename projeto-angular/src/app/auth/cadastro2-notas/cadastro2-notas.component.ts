import { Component } from '@angular/core';
import { SidebarComponent } from '../../layout/sidebar/sidebar.component';
import { HeaderComponent } from '../../layout/header/header.component';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cadastro2-notas',
  imports: [SidebarComponent,HeaderComponent,FormsModule],
  templateUrl: './cadastro2-notas.component.html',
  styleUrl: './cadastro2-notas.component.css'
})
export class Cadastro2NotasComponent {

  constructor(private router:Router){}

  descartar(){}

  cadastrar(){
    
  }


}
