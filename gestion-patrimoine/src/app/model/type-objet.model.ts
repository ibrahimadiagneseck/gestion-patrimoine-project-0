import { Sections } from "./sections.model";

export class TypeObjet {

  public codeTypeObjet: string;
  public libelleTypeObjet: string;
  public codeSection: Sections;

  constructor() {
    this.codeTypeObjet = '';
    this.libelleTypeObjet = '';
    this.codeSection = new Sections() ;
  }

}
