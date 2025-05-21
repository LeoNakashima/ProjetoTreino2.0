import { Component } from '@angular/core';
import { SidebarComponent } from '../../layout/sidebar/sidebar.component';
import { HeaderComponent } from '../../layout/header/header.component';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CadastroNotasService } from '../../cadastro-notas.service';
import { ToastService } from '../../toast.service';
import { AlunoCadastro } from '../../models/models/dtos/alunoCadastro.dto';
import { HttpService } from '../../models/models/services/http.service';

@Component({
  selector: 'app-cadastro2-notas',
  imports: [SidebarComponent,HeaderComponent,FormsModule],
  templateUrl: './cadastro2-notas.component.html',
  styleUrl: './cadastro2-notas.component.css'
})
export class Cadastro2NotasComponent {

  emailTeste:string = "sla@gmail.com"

  constructor(private router:Router, 
    private cadastroNotasService: CadastroNotasService,
    private toast:ToastService,
    private httpService: HttpService
  ){}

  descartar(){
    this.router.navigate(['notas'])

  }

  cadastrar(event?:Event){
     if (event) {
      event.preventDefault(); // Evita o reload do form
    }

    const alunoCadastro: AlunoCadastro = {
          email:this.email,
          senha:this.senha,
          nome:this.nome,
          genero:this.genero,
          data_nascimento:this.data_nascimento,
          tipo_alimentacao:this.tipo_alimentacao
          
        }
   this.httpService.usuarioCadastro(alunoCadastro).subscribe(
      (res: {sucesso:boolean}) =>{
        if(res.sucesso==false){
          this.router.navigate(['../notas'])
        }
        else{}
      
        
      },
      (error: any)=>{
       
        console.log("Erro ao cadastrar",error)
      }

    );
    
  }


}
