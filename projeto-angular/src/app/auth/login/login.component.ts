import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http'; 
import { HeaderComponent } from '../../layout/header/header.component';
import { SidebarComponent } from '../../layout/sidebar/sidebar.component';
import { NgIf } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, HeaderComponent, SidebarComponent, NgIf],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string = '';
  password: string = '';
  loginRejeitado: boolean = false;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private http: HttpClient,
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.loginRejeitado = params.get('error') === "true";
    });
  }

  // Alteração aqui: fazendo o login via API
  fazerLogin(event?: Event) {
    if (event) {
      event.preventDefault(); // Evita o reload do form
    }

    // Criando o objeto que será enviado para a API
    const loginData = {
      email: this.email,
      senha: this.password
    };

    // Enviando a requisição POST para o backend
    this.http.post('http://localhost:8080/api/alunos/login', loginData, { observe: 'response' })
      .subscribe({
        next: (res) => {
          if (res.status === 200) { // Login bem-sucedido
            this.loginRejeitado = false;
            this.router.navigate(['home']);
          }
        },
        error: (err) => {
          if (err.status === 401) { // Login falhou (usuário não autorizado)
            this.loginRejeitado = true;
          }
        }
      });
  }

  // Navega para a tela de cadastro
  fazerCadastro() {
    this.router.navigate(['cadastro-login']);
  }

  // Fecha a mensagem de erro
  fecharErro() {
    this.loginRejeitado = false;
  }
}
