import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthKeyClockGuard } from 'src/app/routeGuards/auth.route';
import { ReceptionVehiculeListeComponent } from './vehicules/reception-vehicule-liste/reception-vehicule-liste.component';
import { ConsultationVehiculeListeComponent } from './vehicules/consultation-vehicule-liste/consultation-vehicule-liste.component';
import { ArticleBonEntreeComponent } from './article-bon-entree/article-bon-entree.component';

const routes: Routes = [
  
  { path: 'consultation-vehicule', component: ConsultationVehiculeListeComponent, canActivate: [AuthKeyClockGuard], data: {
    roles: ['USER']
  }},

  { path: 'reception-vehicule', component: ReceptionVehiculeListeComponent, canActivate: [AuthKeyClockGuard], data: {
    roles: ['USER']
  }},

  { path: 'ajouter-article', component: ArticleBonEntreeComponent, canActivate: [AuthKeyClockGuard], data: {
    roles: ['USER']
  }},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BureauLogistiqueMaterielRoutingModule { }
