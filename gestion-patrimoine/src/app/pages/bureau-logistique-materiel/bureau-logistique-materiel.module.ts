import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BureauLogistiqueMaterielRoutingModule } from './bureau-logistique-materiel-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatDialogModule } from '@angular/material/dialog';
// import { MatTableExporterModule } from 'mat-table-exporter';
import { ComposantModule } from 'src/app/composant/composant.module';
import { ReceptionVehiculeListeComponent } from './vehicules/reception-vehicule-liste/reception-vehicule-liste.component';
import { VehiculeListeComponent } from './vehicules/vehicule-liste/vehicule-liste.component';
import { ReceptionVehiculeAjouterComponent } from './vehicules/reception-vehicule-ajouter/reception-vehicule-ajouter.component';


@NgModule({
  declarations: [

    VehiculeListeComponent,

    ReceptionVehiculeAjouterComponent,
    ReceptionVehiculeListeComponent
  ],
  imports: [
    BrowserModule,
    CommonModule, // ngif ngfor
    FormsModule,
    ReactiveFormsModule, // pour formGroup
    BrowserAnimationsModule,
    HttpClientModule, // pour le backend

    NgbModule, // dropdown

    ComposantModule, // composant

    MatTableModule, MatPaginatorModule,

    // MatPaginator,

    MatExpansionModule,
    MatSlideToggleModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatDialogModule,

    // MatTableExporterModule,

    // MDCDialog

    BureauLogistiqueMaterielRoutingModule
  ]
})
export class BureauLogistiqueMaterielModule { }
