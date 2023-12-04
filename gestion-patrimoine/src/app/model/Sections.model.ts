import { UniteDouaniere } from "./unite-douaniere.model";


export class Sections {

  public codeSection: string;
  public libelleSection: string;
  public codeUniteDouaniere: UniteDouaniere;
 ;


  constructor() {
    this.codeSection = '';
    this.libelleSection = '';
    this.codeUniteDouaniere = new UniteDouaniere() ;


  }

}
