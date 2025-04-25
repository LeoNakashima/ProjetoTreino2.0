import { Routes } from '@angular/router';
import { HomeComponent } from './auth/home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { CadastroComponent } from './auth/cadastro/cadastro.component';
import { GraficoComponent } from './auth/grafico/grafico.component';
import { NotasComponent } from './auth/notas/notas.component';

export const routes: Routes = [
    { path: 'home', component: HomeComponent},
    { path: '', component: LoginComponent},
    { path: 'cadastro', component: CadastroComponent},
    { path: 'grafico', component: GraficoComponent},
    { path: 'notas', component: NotasComponent},
    
];
