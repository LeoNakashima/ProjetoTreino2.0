import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { AlunoCadastro } from '../dtos/alunoCadastro.dto';
import { catchError } from 'rxjs/operators';
import { UsuarioCadastro } from '../dtos/usuarioCadastro.dto';
import { UsuarioLogin } from '../dtos/usuarioLogin.dto';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private apiUrl: string = 'http://localhost:8080';
  constructor(private http: HttpClient) {}

  cadastrarAluno(aluno: AlunoCadastro): Observable<any> {
    return this.http.post(`${this.apiUrl}/cadastrar-notas`, aluno).pipe(
      catchError(this.handleError)  // Tratar erros de cadastro de aluno
    );
  }


  usuarioCadastro(user: UsuarioCadastro): Observable<any> {
    console.log(`${this.apiUrl}/cadastro/cadastrar-usuario`);  // Log para verificar a URL
    return this.http.post(`${this.apiUrl}/cadastro/cadastrar-usuario`, user).pipe(
      catchError(this.handleError)  // Tratar erros de cadastro de usuário
    );
  }

  usuarioLogin(user: UsuarioLogin): Observable<any> {
    console.log(`${this.apiUrl}/`);  
    return this.http.post(`${this.apiUrl}/`, user).pipe(
      catchError(this.handleError)  
    );
  }

  



  // Método para tratar erros nas requisições HTTP
  private handleError(error: HttpErrorResponse): Observable<never> {
    if (error.error instanceof ErrorEvent) {
      // Erro do lado do cliente
      console.error('Erro do lado do cliente:', error.error.message);
    } else {
      // Erro do lado do servidor
      console.error(
        `Código do erro: ${error.status},` +
        `mensagem: ${error.message}`);
    }
    return throwError(() => new Error('Ocorreu um erro. Tente novamente mais tarde.'));
  }
}
