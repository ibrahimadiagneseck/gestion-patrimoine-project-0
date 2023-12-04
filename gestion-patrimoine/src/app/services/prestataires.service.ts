import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { Prestataires } from '../model/prestataires.model';



@Injectable({
  providedIn: 'root'
})
export class PrestatairesService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listePrestataires(): Observable<Prestataires[]> {
    return this.httpClient.get<Prestataires[]>(`${this.urlServeur}/Prestataires`);
  }

  public ajouterPrestataires(formData: FormData): Observable<Prestataires> {
    return this.httpClient.post<Prestataires>(`${this.urlServeur}/AjouterPrestataires`, formData);
  }

  public modifierPrestataires(formData: FormData): Observable<Prestataires> {
    return this.httpClient.post<Prestataires>(`${this.urlServeur}/ModifierPrestataires`, formData);
  }

  public supprimerPrestataires(ninea: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerPrestatairesByPrestatairesId/${ninea}`);
  }


  public createBonEntreeFormData(prestataires: Prestataires): FormData {

    const formData = new FormData();

    formData.append('ninea', prestataires.ninea);
    formData.append('raisonSociale', prestataires.raisonSociale);
    formData.append('numeroTelephone', prestataires.numeroTelephone.toString());
    formData.append('adresse', prestataires.adresse);

    return formData;
  }
}
