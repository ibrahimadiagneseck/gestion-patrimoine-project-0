import { Agent } from "./agent.model";
import { BonEntree } from "./bon-entree.model";
import { MyDate } from "./date.model";
import { TypeObjet } from "./type-objet.model";

export class ArticleBonEntree {


  public identifiantBE: BonEntree;
  public codeArticleBonEntree: number;
  public libelleArticleBonEntree: string;
  public quantiteEntree: number;
  public dateEnregistrement: MyDate;
  public codeTypeObjet: TypeObjet;
  public matriculeAgent: Agent;


  constructor(
    identifiantBE = new BonEntree(),
    codeArticleBonEntree = 0,
    libelleArticleBonEntree = '',
    quantiteEntree = 0,
    dateEnregistrement = new MyDate(),
    codeTypeObjet = new TypeObjet(),
    matriculeAgent = new Agent()
  ) {
    this.identifiantBE = identifiantBE;
    this.codeArticleBonEntree = codeArticleBonEntree;
    this.libelleArticleBonEntree = libelleArticleBonEntree;
    this.quantiteEntree = quantiteEntree;
    this.dateEnregistrement = dateEnregistrement;
    this.codeTypeObjet = codeTypeObjet;
    this.matriculeAgent = matriculeAgent;
  }

}

