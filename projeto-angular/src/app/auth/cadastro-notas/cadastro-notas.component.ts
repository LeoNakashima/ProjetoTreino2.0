import { Component } from '@angular/core';
import { SidebarComponent } from '../../layout/sidebar/sidebar.component';
import { HeaderComponent } from '../../layout/header/header.component';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cadastro-notas',
  imports: [SidebarComponent,HeaderComponent,FormsModule],
  templateUrl: './cadastro-notas.component.html',
  styleUrl: './cadastro-notas.component.css'
})
export class CadastroNotasComponent {

  constructor (private router: Router){}

  descartar(){
    this.router.navigate([''])

  }

  proximo(){
    this.router.navigate(['cadastro2-notas'])
    
  }

}
