import { APP_INITIALIZER, LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ConnexionComponent } from './pages/connexion/connexion.component';
import { ErreurComponent } from './pages/erreur/erreur.component';



import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import {MatExpansionModule} from '@angular/material/expansion';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import {MatDividerModule} from '@angular/material/divider';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { CommonModule, DatePipe, registerLocaleData } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
// import { NotifierModule, NotifierOptions } from 'angular-notifier';

import localeFr from '@angular/common/locales/fr';
// import { MatTableExporterModule } from 'mat-table-exporter';

// import { UtilisateurListeComponent } from './pages/utilisateur/utilisateur-liste/utilisateur-liste.component';

import { BureauLogistiqueMaterielModule } from './pages/bureau-logistique-materiel/bureau-logistique-materiel.module';
import { NgToastModule } from 'ng-angular-popup';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { ComposantModule } from './composant/composant.module';
import { PrestataireSecteurListeComponent } from './pages/prestataire/prestataire-secteur-liste/prestataire-secteur-liste.component';
import { PrestataireSecteurAjouterComponent } from './pages/prestataire/prestataire-secteur-ajouter/prestataire-secteur-ajouter.component';
import { PrestataireSecteurDetailComponent } from './pages/prestataire/prestataire-secteur-detail/prestataire-secteur-detail.component';



// the second parameter 'fr' is optional
registerLocaleData(localeFr, 'fr');



function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'gestion-patrimoine',
        clientId: 'gestion-patrimoine'
      },
      initOptions: {
        pkceMethod: 'S256',
        redirectUri: 'http://localhost:4200/accueil',
        // onLoad: 'check-sso',
        // silentCheckSsoRedirectUri: window.location.origin + '/assets/silent-check-sso.html'
      },
      loadUserProfileAtStartUp: false // qui charge le profil utilisateur au démarrage comme faux.
    });
}


@NgModule({
  declarations: [

    AppComponent,

    AccueilComponent,

    ConnexionComponent,

    ErreurComponent,
    
    PrestataireSecteurListeComponent,
    PrestataireSecteurAjouterComponent,
    PrestataireSecteurDetailComponent
    
  ],
  imports: [
    BrowserModule,
    CommonModule, // ngif ngfor
    FormsModule,
    ReactiveFormsModule, // pour formGroup
    BrowserAnimationsModule,
    HttpClientModule, // pour le backend

    ComposantModule, // composant

    KeycloakAngularModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'XSRF-TOKEN',
      headerName: 'X-XSRF-TOKEN',
    }),
    
    NgToastModule,
    // NotifierModule.withConfig(
    //   // customNotifierOptions1 // Custom options in here
    // ),

    NgbModule, // dropdown

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

    BureauLogistiqueMaterielModule,
    AppRoutingModule
    
  ],
  providers: [
    { 
      provide: LOCALE_ID, useValue: "fr-FR"
    },
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService],
   },
   DatePipe,
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
