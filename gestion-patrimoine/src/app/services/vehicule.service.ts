import { HttpClient, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Vehicule } from '../model/vehicule.model';
import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';

@Injectable({
  providedIn: 'root',
})
export class VehiculeService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}

  // ----------------------------------------------------------------------------
  // RECHERCHER VEHICULE SANS DOUBLONS
  public searchVehiculeListFilterDouble(term: string, listeVehicules: Vehicule[]): Observable<Vehicule[]> {

    if (term.length <= 1) {
      return of([]);
    }

    // Filtrer la liste de vehicule en fonction du terme de recherche
    const filteredVehicules = listeVehicules.filter((vehicule) =>
      vehicule.numeroSerie.toString().includes(term.toLowerCase()) || vehicule.modele.toLowerCase().includes(term.toLowerCase())
    );

    // Utilisation de la méthode filter() pour éliminer les doublons
    const filteredVehicules1: Vehicule[] = filteredVehicules.filter((item, index, self) =>
      index === self.findIndex((t) => (
          t.modele === item.modele || t.numeroSerie === item.numeroSerie
      ))
    );

    return of(filteredVehicules1);
  }

  // RECHERCHER VEHICULE
  public searchVehiculeList(term: string, listeVehicules: Vehicule[]): Observable<Vehicule[]> {
    if (term.length <= 1) {
      return of([]);
    }

    // Filtrer la liste de vehicule en fonction du terme de recherche
    const filteredVehicules = listeVehicules.filter((vehicule) =>
      this.doesVehiculeMatchTerm(vehicule, term)
    );

    return of(filteredVehicules);
  }

  private doesVehiculeMatchTerm(vehicule: Vehicule, term: string): boolean {
    // Vérifier si le terme de recherche correspond à n'importe lequel des attributs du vehicule
    const termLowerCase = term.toLowerCase();
    return (
      vehicule.numeroSerie.toString().includes(termLowerCase) || vehicule.modele.toLowerCase().includes(termLowerCase)
      // Ajoutez d'autres attributs à vérifier si nécessaire
    );
  }
  // ----------------------------------------------------------------------------


  // ----------------------------------------------------------------------------
  //  CRUD VEHICULE

  public listeVehicules(): Observable<Vehicule[]> {
    return this.httpClient.get<Vehicule[]>(`${this.urlServeur}/Vehicules`);
  }

  public ajouterVehicule(vehicule: Vehicule): Observable<Vehicule> {
    return this.httpClient.post<Vehicule>(`${this.urlServeur}/AjouterVehicule`, vehicule);
  }

  public ajouterVehiculeRequestParam(formData: FormData): Observable<Vehicule> {
    return this.httpClient.post<Vehicule>(`${this.urlServeur}/AjouterRequestParamVehicule`, formData);
  }

  public modifierVehicule(formData: FormData): Observable<Vehicule> {
    return this.httpClient.post<Vehicule>(`${this.urlServeur}/ModifierVehicule`, formData);
  }

  public supprimerVehiculeById(numeroSerie: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerVehiculeById/${numeroSerie}`);
  }


  public createVehiculeFormDate(vehicule: Vehicule): FormData {

    const formData = new FormData();

    formData.append('numeroSerie', vehicule.numeroSerie);
    formData.append('numeroImmatriculation', vehicule.numeroImmatriculation);
    formData.append('identifiantBE', JSON.stringify(vehicule.identifiantBE));
    formData.append('genre', vehicule.genre);
    formData.append('modele', vehicule.modele);
    formData.append('etatVehicule', vehicule.etatVehicule);
    formData.append('typeEnergie', vehicule.typeEnergie);
    formData.append('codePays', JSON.stringify(vehicule.codePays));
    formData.append('numeroCarteGrise', vehicule.numeroCarteGrise);
    formData.append('dateMiseEnCirculation', JSON.stringify(vehicule.dateMiseEnCirculation));
    formData.append('codeTypeVehicule', JSON.stringify(vehicule.codeTypeVehicule));
    formData.append('codeMarque', JSON.stringify(vehicule.codeMarque));
    formData.append('codeUniteDouaniere', JSON.stringify(vehicule.codeUniteDouaniere));

    return formData;
  }


}
// ----------------------------------------------------------------------------
