import { Agent } from "./agent.model";
import { BordereauLivraison } from "./bordereau-livraison.model";
import { Sections } from "./sections.model";

export class BonEntree {

  public rowNumber: number;
  public nombreArticleBonEntree: number;
  public identifiantBE: string;
  public numeroBE: string;
  public libelleBonEntree: string;
  public dateBonEntree: Date;
  public observationBonEntree:string;
  public dateEnregistrement: number;
  public identifiantBL: BordereauLivraison;
  public matriculeAgent: Agent;
  public codeSection: Sections;



  constructor() {
    this.rowNumber = 0;
    this.nombreArticleBonEntree = 0;
    this.identifiantBE = '';
    this.numeroBE = '';
    this.libelleBonEntree = '';
    this.dateBonEntree = new Date();
    this.observationBonEntree = '';
    this.dateEnregistrement = new Date().getTime();
    this.identifiantBL = new BordereauLivraison() ;
    this.matriculeAgent = new Agent() ;
    this.codeSection = new Sections() ;



  }

}
