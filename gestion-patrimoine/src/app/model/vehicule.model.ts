import { Agent } from "./agent.model";
import { ArticleBonEntree } from "./article-bon-entree.model";
import { BonEntree } from "./bon-entree.model";
import { MarqueVehicule } from "./marque-vehicule.model";
import { Pays } from "./pays.model";
import { TypeObjet } from "./type-objet.model";
import { TypeVehicule } from "./type-vehicule.model";
import { UniteDouaniere } from "./unite-douaniere.model";


export class Vehicule {

  public rowNumber: number;
  public numeroSerie: string;
  public numeroImmatriculation: string;
  public identifiantBE: ArticleBonEntree;
  public genre: string;
  public modele: string;
  public etatVehicule: string;
  public typeEnergie: string;
  public codePays: Pays;
  public numeroCarteGrise: string;
  public dateMiseEnCirculation: Date;
  public codeTypeVehicule: TypeVehicule;
  public codeMarque: MarqueVehicule;
  public codeUniteDouaniere: UniteDouaniere;


  constructor() {
    this.rowNumber = 0;
    this.numeroSerie = '';
    this.codeTypeVehicule = new TypeVehicule() ;
    this.numeroImmatriculation = '';
    this.genre = '';
    this.codeMarque = new MarqueVehicule() ;
    this.modele ='';
    this.etatVehicule ='';
    this.typeEnergie = '';
    this.codePays = new Pays() ;
    this.numeroCarteGrise = '';
    this.dateMiseEnCirculation = new Date();
    this.codeUniteDouaniere = new UniteDouaniere() ;
    this.identifiantBE = new ArticleBonEntree() ;
  }

}
