import { CorpsAgent } from "./corps-agent.model";
import { FonctionAgent } from "./fonction-agent.model";
import { UniteDouaniere } from "./unite-douaniere.model";


export class Agent {

  public matriculeAgent: string;
  public codeAgent: string;
  public nomAgent: string;
  public prenomAgent: string;
  public numeroTelephoneAgent: number;
  public fonctionAgent: FonctionAgent;
  public uniteDouaniere: UniteDouaniere;
  public codeCorpsAgent: CorpsAgent;


  constructor() {
    this.matriculeAgent = '';
    this.codeAgent = '';
    this.nomAgent = '';
    this.prenomAgent = '';
    this.numeroTelephoneAgent = 0;
    this.fonctionAgent = new FonctionAgent() ;
    this.uniteDouaniere = new UniteDouaniere() ;
    this.codeCorpsAgent = new CorpsAgent() ;


  }

}
