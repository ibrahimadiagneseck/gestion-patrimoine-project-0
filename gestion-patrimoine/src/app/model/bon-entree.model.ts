import { BordereauLivraison } from "./bordereau-livraison.model";

export class BonEntree {

  public rowNumber: number;
  public identifiantBE: string;
  public numeroBE: string;
  public libelleBonEntree: string;
  public dateBonEntree: Date;
  public observationBonEntree:string;
  public identifiantBL: BordereauLivraison;
  public rowNombreArticleBonEntree: number;


  constructor() {
    this.rowNumber = 0;
    this.identifiantBE = '';
    this.numeroBE = '';
    this.libelleBonEntree = '';
    this.dateBonEntree = new Date();
    this.observationBonEntree = '';
    this.identifiantBL = new BordereauLivraison() ;
    this.rowNombreArticleBonEntree = 0;
  }

}
