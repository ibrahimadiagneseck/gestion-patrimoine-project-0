import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BonEntree } from 'src/app/model/bon-entree.model';
import { Pays } from 'src/app/model/pays.model';
import { UniteDouaniere } from 'src/app/model/unite-douaniere.model';
import { TypeObjet } from 'src/app/model/type-objet.model';
import { Vehicule } from 'src/app/model/vehicule.model';
import { MarqueVehicule } from 'src/app/model/marque-vehicule.model';
import { TypeVehicule } from 'src/app/model/type-vehicule.model';
import { ArticleBonEntree } from 'src/app/model/article-bon-entree.model';
import { Subscription } from 'rxjs';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { ArticleBonEntreeService } from 'src/app/services/article-bon-entree.service';

@Component({
  selector: 'app-article-bon-entree-ajouter',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './article-bon-entree-ajouter.component.html',
  styleUrl: './article-bon-entree-ajouter.component.css'
})
export class ArticleBonEntreeAjouterComponent {


  public bonEntrees: BonEntree[] = [];
  public bonEntree: BonEntree = new BonEntree();

  public payss: Pays[] = [];
  public pays: Pays = new Pays();

  public uniteDouanieres: UniteDouaniere[] = [];
  public uniteDouaniere: UniteDouaniere = new UniteDouaniere();

  public typeObjets: TypeObjet[] = [];
  public typeObjet: TypeObjet = new TypeObjet();

  public vehicules: Vehicule[] = [];
  public vehicule: Vehicule = new Vehicule();

  public marqueVehicules: MarqueVehicule[] = [];
  public marqueVehicule: MarqueVehicule = new MarqueVehicule();

  public typeVehicules: TypeVehicule[] = [];
  public typeVehicule: TypeVehicule = new TypeVehicule();

  public articleBonEntrees: ArticleBonEntree[] = [];
  public articleBonEntree: ArticleBonEntree = new ArticleBonEntree();



  private subscriptions: Subscription[] = [];

  constructor(

    private articleBonEntreeService: ArticleBonEntreeService,
    private matDialog: MatDialog,
    public dialogRef: MatDialogRef<ArticleBonEntreeAjouterComponent>
    // @Inject(MAT_DIALOG_DATA) public data: string,
    // private matDialog: MatDialog

  ) { }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  ngOnInit(): void {
    // this.listeSections();
    // this.listeBordereauLivraisons();
    // this.listeAgents();
  }



  public ajouterArticleBonEntree(articleBonEntreeForm: NgForm): void {

    // const formData = this.bonEntreeService.createBonEntreeFormData(bonEntreeForm.value);

    console.log(articleBonEntreeForm.value);

    this.subscriptions.push(
      this.articleBonEntreeService.ajouterArticleBonEntree(articleBonEntreeForm.value).subscribe({
        next: (response: ArticleBonEntree) => {

        },
        error: (errorResponse: HttpErrorResponse) => {

        }
      })
    );
  }




  popupFermer(): void {
    this.dialogRef.close();
  }





}
