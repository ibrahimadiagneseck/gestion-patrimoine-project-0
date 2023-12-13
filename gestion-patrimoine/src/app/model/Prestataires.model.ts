import { SecteurActivite } from "./secteur-activite.model";

export class Prestataires {

  public rowNumber: number;
  public ninea: string;
  public raisonSociale: string;
  public numeroTelephone: number;
  public adresse: string;
  public adresseEmail: string;
  public secteurActivite: SecteurActivite[] = [];

  constructor(
    rowNumber: number = 0,
    ninea: string = '',
    raisonSociale: string = '',
    numeroTelephone: number = 0,
    adresse: string = '',
    adresseEmail: string = '',
    secteurActivite: SecteurActivite[] = []
  ) {
    this.rowNumber = rowNumber;;
    this.ninea = ninea;
    this.raisonSociale = raisonSociale;
    this.numeroTelephone = numeroTelephone;
    this.adresse = adresse;
    this.adresseEmail = adresseEmail;
    this.secteurActivite = secteurActivite;
  }

}
