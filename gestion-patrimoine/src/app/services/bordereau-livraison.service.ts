import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { BordereauLivraison } from '../model/bordereau-livraison.model';

@Injectable({
  providedIn: 'root'
})
export class BordereauLivraisonService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listeBordereauLivraisons(): Observable<BordereauLivraison[]> {
    return this.httpClient.get<BordereauLivraison[]>(`${this.urlServeur}/BordereauLivraisons`);
  }

  public ajouterBordereauLivraison(bordereauLivraison: BordereauLivraison): Observable<BordereauLivraison> {
    return this.httpClient.post<BordereauLivraison>(`${this.urlServeur}/AjouterBordereauLivraison`, bordereauLivraison);
  }

  public ajouterBordereauLivraisonRequestParam(formData: FormData): Observable<BordereauLivraison> {
    return this.httpClient.post<BordereauLivraison>(`${this.urlServeur}/AjouterRequestParamBordereauLivraison`, formData);
  }

  public modifierBordereauLivraison(formData: FormData): Observable<BordereauLivraison> {
    return this.httpClient.post<BordereauLivraison>(`${this.urlServeur}/ModifierBordereauLivraison`, formData);
  }

  public supprimerBordereauLivraisonById(identifiantBL: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerBordereauLivraisonById/${identifiantBL}`);
  }


  public createBordereauLivraisonFormData(bordereauLivraison: BordereauLivraison): FormData {

    const formData = new FormData();

    formData.append('numeroBL', bordereauLivraison.numeroBL);
    formData.append('descriptionBL', bordereauLivraison.descriptionBL);
    formData.append('lieuDeLivraison', bordereauLivraison.lieuDeLivraison);
    formData.append('dateBL', JSON.stringify(bordereauLivraison.dateBL));
    formData.append('conformiteBL', bordereauLivraison.conformiteBL);
    formData.append('nomLivreur', bordereauLivraison.nomLivreur);
    formData.append('codeSection', JSON.stringify(bordereauLivraison.codeSection));
    formData.append('ninea', JSON.stringify(bordereauLivraison.ninea));
    formData.append('matriculeAgent', JSON.stringify(bordereauLivraison.matriculeAgent));


    return formData;
  }
}
