import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { BordereauLivraison } from '../model/bordereau-livraison.model';
import { DatePipe } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class BordereauLivraisonService {

  private urlServeur = environment.apiUrl;

  constructor(
    private httpClient: HttpClient
    ) {}


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

    const { year, month, day } = bordereauLivraison.dateBL;
    
    const date = new Date(year, month - 1, day);
    const datePipe = new DatePipe('en-US');
    const formattedDate = datePipe.transform(date, 'yyyy-MM-dd') ?? '';

    // console.log(bordereauLivraison);
    // console.log(formattedDate);

    formData.append('numeroBL', bordereauLivraison.numeroBL);
    formData.append('descriptionBL', bordereauLivraison.descriptionBL);
    formData.append('lieuDeLivraison', bordereauLivraison.lieuDeLivraison);
    formData.append('dateBL', formattedDate);
    formData.append('conformiteBL', bordereauLivraison.conformiteBL);
    formData.append('nomLivreur', bordereauLivraison.nomLivreur);
    formData.append('codeSection', JSON.stringify(bordereauLivraison.codeSection));
    formData.append('ninea', JSON.stringify(bordereauLivraison.ninea));
    formData.append('matriculeAgent', JSON.stringify(bordereauLivraison.matriculeAgent));

    return formData;
  }
}
