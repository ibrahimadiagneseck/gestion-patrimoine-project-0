import { Agent } from "./agent.model";
import { BonEntree } from "./bon-entree.model";
import { TypeObjet } from "./type-objet.model";

export class ArticleBonEntree {


  public identifiantBE: BonEntree;
  public codeArticleBonEntree: number;
  public libelleArticleBonEntree: string;
  public quantiteEntree: number;
  public dateEnregistrement: number;
  public codeTypeObjet: TypeObjet;
  public matriculeAgent: Agent;


  constructor() {
    this.identifiantBE = new BonEntree() ;
    this.codeArticleBonEntree = 0;
    this.libelleArticleBonEntree = '';
    this.quantiteEntree = 0;
    this.dateEnregistrement = new Date().getTime();
    this.codeTypeObjet = new TypeObjet() ;
    this.matriculeAgent = new Agent() ;
  }

}
