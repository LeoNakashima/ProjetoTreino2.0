import { Routes } from '@angular/router';
<<<<<<< HEAD
import { HomeComponent } from './auth/home/home.component';
import { HeaderComponent } from './layout/header/header.component';
import { LoginComponent } from './auth/login/login.component';
import { CadastroComponent } from './auth/cadastro/cadastro.component';
import { GraficoComponent } from './auth/grafico/grafico.component';

export const routes: Routes = [
    { path: 'home', component: HomeComponent},
    { path: '', component: LoginComponent},
    { path: 'cadastro', component: CadastroComponent},
    { path: 'grafico', component: GraficoComponent}
    
];
=======
import { LaboratorioGerminaresComponent } from './pages/laboratorio-germinares/laboratorio-germinares.component';
import { GerenciamentoComponent } from './pages/gerenciamento/gerenciamento.component';

export const routes: Routes = [
  { path: '', redirectTo: 'gerenciamento', pathMatch: 'full' },
  { path: 'gerenciamento', component: GerenciamentoComponent },
  { path: 'laboratorio-germinares', component: LaboratorioGerminaresComponent }
];
>>>>>>> c8bffb14c96370a014c623f3299fd4b39a038196
