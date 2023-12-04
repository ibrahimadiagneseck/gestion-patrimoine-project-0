import { TypeUniteDouaniere } from "./type-unite-douaniere.model";

export class UniteDouaniere {

  public codeUniteDouaniere: string;
  public nomUniteDouaniere: string;
  public effectifUniteDouaniere: number;
  public nombreArme:number;
  public nombreAutomobile:number;
  public nombreMateriel:number;
  public codeTypeUniteDouaniere: TypeUniteDouaniere;


  constructor() {
    this.codeUniteDouaniere = '';
    this.nomUniteDouaniere = '';
    this.effectifUniteDouaniere = 0;
    this.nombreArme =0;
    this.nombreAutomobile = 0;
    this.nombreMateriel =0;
    this.codeTypeUniteDouaniere = new TypeUniteDouaniere() ;

  }

}
