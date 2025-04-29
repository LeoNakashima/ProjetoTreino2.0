  import { Component } from '@angular/core';
  import { FormsModule } from '@angular/forms';
  import { Router } from '@angular/router';
  import { HeaderComponent } from '../../layout/header/header.component';
  import { SidebarComponent } from '../../layout/sidebar/sidebar.component';
  import { NgIf } from '@angular/common';


  @Component({
    selector: 'app-login',
    standalone: true,
    imports: [FormsModule, HeaderComponent, SidebarComponent, NgIf],
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
  })
  export class LoginComponent {
    email: string = '';
    password: string = '';
    loginRejeitado: boolean = false;

    constructor(private router: Router) {}

    fazerLogin(event?: Event) {
      if (event) {
        event.preventDefault(); // Evita o reload do form
      }

      // Simulação de usuários cadastrados
      const usuariosCadastrados = [
        { email: 'teste@email.com', senha: '123456' },
        { email: 'usuario@email.com', senha: 'abcdef' }
      ];

      const usuarioEncontrado = usuariosCadastrados.find(user =>
        user.email === this.email && user.senha === this.password
      );

      if (usuarioEncontrado) {
        this.loginRejeitado = false;
        this.router.navigate(['home']);
      } else {
        this.loginRejeitado = true;

      }
    }

    fazerCadastro() {
      this.router.navigate(['cadastro-login']);
    }

    fecharErro() {
      this.loginRejeitado = false;
    }
  }
