import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './pages/connexion/connexion.component';
import { ErreurComponent } from './pages/erreur/erreur.component';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { AuthKeyClockGuard } from './routeGuards/auth.route';
import { UtilisateurListeComponent } from './pages/utilisateur/utilisateur-liste/utilisateur-liste.component';
import { PrestataireSecteurListeComponent } from './pages/prestataire/prestataire-secteur-liste/prestataire-secteur-liste.component';

const routes: Routes = [

  { path: '', redirectTo: '/connexion', pathMatch: 'full'},
  { path: 'connexion', component: ConnexionComponent },

  { path: 'accueil', component: AccueilComponent, canActivate: [AuthKeyClockGuard], data: {
    roles: ['USER','ADMIN']
  }},

  { path: 'prestataire', component: PrestataireSecteurListeComponent, canActivate: [AuthKeyClockGuard], data: {
    roles: ['USER']
  }},

  { path: 'gestion-utilisateur', component: UtilisateurListeComponent, canActivate: [AuthKeyClockGuard], data: {
    roles: ['USER']
  }},


  { path: 'erreur', component: ErreurComponent },
  // { path: '**', redirectTo: 'erreur', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
