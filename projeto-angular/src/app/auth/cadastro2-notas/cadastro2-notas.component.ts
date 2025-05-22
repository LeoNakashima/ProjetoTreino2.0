import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CadastroNotasService } from '../../cadastro-notas.service';
import { ToastService } from '../../toast.service';
import { AlunoCadastro } from '../../models/models/dtos/alunoCadastro.dto';
import { HttpService } from '../../models/models/services/http.service';

@Component({
  selector: 'app-cadastro2-notas',
  templateUrl: './cadastro2-notas.component.html',
  styleUrls: ['./cadastro2-notas.component.css']
})
export class Cadastro2NotasComponent {

  linguagens: number | null = null;
  exatas: number | null = null;
  ciencias: number | null = null;

  constructor(
    private router: Router,
    private cadastroNotasService: CadastroNotasService,
    public toast: ToastService,
    private httpService: HttpService
  ) {}

  descartar() {
    this.router.navigate(['/notas']);
  }

  cadastrar(event?: Event) {
    if (event) {
      event.preventDefault(); // Evita o reload do form
    }

    const alunoCadastro: AlunoCadastro = {
      nome_completo:this.cadastroNotasService.nomeCompleto,
      email:this.cadastroNotasService.email,
      genero:this.cadastroNotasService.genero,
      data_nascimento:this.cadastroNotasService.data_nascimento,
      tipo_alimentacao:this.cadastroNotasService.tipo_alimentacao,
      escolaridade_pais:this.cadastroNotasService.escolaridade,
      linguagens:this.linguagens,
      exatas:this.exatas,
      ciencias:this.ciencias

    };

    this.httpService.cadastrarAluno(alunoCadastro).subscribe(
      (res: { sucesso: boolean }) => {
        if (res.sucesso) {
          this.toast.exibirToast("Cadastro realizado com sucesso", '../../assets/aprovado.png');
          this.router.navigate(['/notas']);
        } else {
          this.toast.exibirToast("Falha no cadastro", '../../assets/reprovado.png');
        }
      },
      (error: any) => {
        console.log("Erro ao cadastrar", error);
        this.toast.exibirToast("Erro ao cadastrar", '../../assets/reprovado.png');
      }
    );
  }
}
