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
  public codeTypeVehicule: TypeVehicule;
  public numeroImmatriculation: string;
  public genre: string;
  public codeMarque: MarqueVehicule;
  public modele: string;
  public etatVehicule: string;
  public typeEnergie: string;
  public codePays: Pays;
  public numeroCarteGrise: string;
  public dateMiseEnCirculation: Date;
  public codeUniteDouaniere: UniteDouaniere;
  public matriculeAgent: Agent;
  // public codeCorpsAgent: Agent;
  public codeTypeObjet: TypeObjet;
  public identifiantBE: ArticleBonEntree;
  // public codeArticleBonEntree: ArticleBonEntree;


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
    this.matriculeAgent = new Agent() ;
    // this.codeCorpsAgent = new Agent() ;
    this.codeTypeObjet = new TypeObjet() ;
    this.identifiantBE = new ArticleBonEntree() ;
    // this.codeArticleBonEntree = new ArticleBonEntree() ;
  }

}

    // private String numeroSerie;
    // private String numeroImmatriculation;
    // private String genre;
    // private String modele;
    // private String etatVehicule;
    // private String typeEnergie;
    // private String numeroCarteGrise;
    // private Date dateMiseEnCirculation;
    // private Pays codePays;
    // private TypeVehicule codeTypeVehicule;
    // private MarqueVehicule codeMarque;
    // private UniteDouaniere codeUniteDouaniere;
    // private ArticleBonEntree identifiantBE;
    // private Agent matriculeAgent;
    // private TypeObjet codeTypeObjet;
