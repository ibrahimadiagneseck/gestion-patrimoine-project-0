import { Agent } from "./agent.model";
import { Prestataires } from "./prestataires.model";
import { Sections } from "./sections.model";



export class BordereauLivraison {

  // public identifiantBL: string;
  public numeroBL: string;
  public descriptionBL: string;
  public lieuDeLivraison: string;
  public dateBL:Date;
  public conformiteBL:string;
  public nomLivreur:string;
  public codeSection: Sections;
  public ninea: Prestataires;
  public matriculeAgent: Agent;
  // public dateEnregistrement: number;


  constructor() {
    // this.identifiantBL = '';
    this.numeroBL = '';
    this.descriptionBL = '';
    this.lieuDeLivraison = '';
    this.dateBL = new Date();
    this.conformiteBL ='';
    this.nomLivreur ='';
    this.codeSection = new Sections() ;
    this.ninea = new Prestataires() ;
    this.matriculeAgent = new Agent() ;
    // this.dateEnregistrement = new Date().getTime();



  }

}
