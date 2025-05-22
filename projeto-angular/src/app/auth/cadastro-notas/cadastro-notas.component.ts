import { Component } from '@angular/core';
import { SidebarComponent } from '../../layout/sidebar/sidebar.component';
import { HeaderComponent } from '../../layout/header/header.component';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CadastroNotasService } from '../../cadastro-notas.service';

@Component({
  selector: 'app-cadastro-notas',
  imports: [SidebarComponent,HeaderComponent,FormsModule],
  templateUrl: './cadastro-notas.component.html',
  styleUrl: './cadastro-notas.component.css'
})
export class CadastroNotasComponent {

  email:string = "";
  nomeCompleto: any;
  genero: any;
  data_nascimento: any;
  tipo_alimentacao: any;
  escolaridade: any;



  constructor (private router: Router, private cadastroNotasService: CadastroNotasService){}

  descartar(){
    this.router.navigate(['notas'])

  }

  proximo(){
    this.cadastroNotasService.email = this.email
    this.cadastroNotasService.nomeCompleto = this.nomeCompleto
    this.cadastroNotasService.genero = this.genero
    this.cadastroNotasService.data_nascimento = this.data_nascimento
    this.cadastroNotasService.tipo_alimentacao = this.tipo_alimentacao
    this.cadastroNotasService.escolaridade=this.escolaridade
  
    this.router.navigate(['cadastro2-notas'])
    
  }

}
