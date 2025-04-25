import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { HeaderComponent } from '../../layout/header/header.component';
import { SidebarComponent } from '../../layout/sidebar/sidebar.component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, HeaderComponent, SidebarComponent],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private router: Router) {}


  fazerLogin(){
    // Aqui você validaria o login, e ao sucesso:
      this.router.navigate(['home']);
      alert("Login efetuado com sucesso!");
    
  }
  fazerCadastro() {
    this.router.navigate(['cadastro']);
  }
  
}

