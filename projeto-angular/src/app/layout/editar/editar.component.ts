import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar',
  imports: [FormsModule],
  templateUrl: './editar.component.html',
  styleUrl: './editar.component.css'
})
export class EditarComponent {
  formData = {
    nome: '',
    email: '',
    ano: '',
    serie: '',
    exatas: 0,
    linguagens: 0,
    ciencias: 0
  };

  onSubmit() {
    console.log('Dados salvos:', this.formData);
    // Aqui você pode chamar um serviço para salvar os dados
  }

  onDiscard() {
    this.formData = {
      nome: '',
      email: '',
      ano: '',
      serie: '',
      exatas: 0,
      linguagens: 0,
      ciencias: 0
    };
  }
}
