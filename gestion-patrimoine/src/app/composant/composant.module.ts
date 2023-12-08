import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoaderComponent } from './loader/loader.component';
import { EnteteComponent } from './entete/entete.component';
import { MenuComponent } from './menu/menu.component';
import { PopupConfirmationSupprimerComponent } from './popup-confirmation-supprimer/popup-confirmation-supprimer.component';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatDialogModule } from '@angular/material/dialog';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from '../app-routing.module';
import { BonEntreeComponent } from './bon-entree/bon-entree.component';
import { ArticleBonEntreeComponent } from './article-bon-entree/article-bon-entree.component';
import { VehiculeComponent } from './vehicule/vehicule.component';
import { BordereauLivraisonComponent } from './bordereau-livraison/bordereau-livraison.component';



@NgModule({
  declarations: [
    // composants
    LoaderComponent,
    EnteteComponent,
    MenuComponent,
    PopupConfirmationSupprimerComponent,
    BonEntreeComponent,
    ArticleBonEntreeComponent,
    BordereauLivraisonComponent,
    VehiculeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    NgbModule, // dropdown

    MatExpansionModule,
    MatSlideToggleModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatDialogModule,
    
    AppRoutingModule  
  ],
  exports: [
    // composants
    LoaderComponent,
    EnteteComponent,
    MenuComponent,
    PopupConfirmationSupprimerComponent,
    BonEntreeComponent,
    ArticleBonEntreeComponent,
    BordereauLivraisonComponent,
    VehiculeComponent
  ]
})
export class ComposantModule { }
