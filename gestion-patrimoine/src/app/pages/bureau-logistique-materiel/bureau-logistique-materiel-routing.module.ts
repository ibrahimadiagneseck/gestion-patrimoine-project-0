import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthKeyClockGuard } from 'src/app/routeGuards/auth.route';
import { ReceptionVehiculeListeComponent } from './vehicules/reception-vehicule-liste/reception-vehicule-liste.component';
import { VehiculeListeComponent } from './vehicules/vehicule-liste/vehicule-liste.component';

const routes: Routes = [
  
  { path: 'vehicules', component: VehiculeListeComponent, canActivate: [AuthKeyClockGuard], data: {
    roles: ['USER']
  }},

  { path: 'reception-vehicule', component: ReceptionVehiculeListeComponent, canActivate: [AuthKeyClockGuard], data: {
    roles: ['USER']
  }},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BureauLogistiqueMaterielRoutingModule { }
