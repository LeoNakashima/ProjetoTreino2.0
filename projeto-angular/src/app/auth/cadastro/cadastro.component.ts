import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from '../../layout/header/header.component';
import { SidebarComponent } from '../../layout/sidebar/sidebar.component';
import { UsuarioCadastro } from '../../models/models/dtos/usuarioCadastro.dto';
import { HttpService } from '../../models/models/services/http.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  standalone: true,
  imports: [FormsModule, HeaderComponent, SidebarComponent],
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent {
  email: string = "";
  senha: number = 0;
  nome: string = "";
  genero: string = "";
  data_nascimento: Date = new Date();
  tipo_alimentacao: string = "";
  cadastroRejeitado: boolean = false;

  usuariosCadastrados = [
    { email: 'teste@exemplo.com' },
    { email: 'outro@exemplo.com' }
  ];

  constructor(private router: Router,private route: ActivatedRoute,private httpService: HttpService) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.cadastroRejeitado = params.get('error') === "true";
    });
  }

  fazerCadastro(event?:Event) {
    if (event) {
      event.preventDefault(); // Evita o reload do form
    }
    const usuarioCadastro: UsuarioCadastro = {
      email:this.email,
      senha:this.senha,
      nome:this.nome,
      genero:this.genero,
      data_nascimento:this.data_nascimento,
      tipo_alimentacao:this.tipo_alimentacao
    }

    this.httpService.usuarioCadastro(usuarioCadastro).subscribe(
      (res: {sucesso:boolean}) =>{
        if(res.sucesso==false){
          this.cadastroRejeitado = false;
          this.router.navigate(['../notas'])
        }
        else{
          this.cadastroRejeitado = true;
      
        }
      },
      (error: any)=>{
        this.cadastroRejeitado = false;
        console.log("Erro ao cadastrar",error)
      }

    );
    
  }

  fecharErro() {
    this.cadastroRejeitado = false;
  }
}