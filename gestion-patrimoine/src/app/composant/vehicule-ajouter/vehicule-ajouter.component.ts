import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TypeVehicule } from 'src/app/model/type-vehicule.model';
import { MarqueVehicule } from 'src/app/model/marque-vehicule.model';
import { UniteDouaniere } from 'src/app/model/unite-douaniere.model';
import { Vehicule } from 'src/app/model/vehicule.model';
import { ArticleBonEntree } from 'src/app/model/article-bon-entree.model';
import { Pays } from 'src/app/model/pays.model';
import { Subscription } from 'rxjs';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { VehiculeService } from 'src/app/services/vehicule.service';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-vehicule-ajouter',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './vehicule-ajouter.component.html',
  styleUrl: './vehicule-ajouter.component.css'
})
export class VehiculeAjouterComponent {

  public typeVehicules: TypeVehicule[] = [];
  public typeVehicule: TypeVehicule = new TypeVehicule();

  public marqueVehicules: MarqueVehicule[] = [];
  public marqueVehicule: MarqueVehicule = new MarqueVehicule();

  public uniteDouanieres: UniteDouaniere[] = [];
  public uniteDouaniere: UniteDouaniere = new UniteDouaniere();

  public vehicules: Vehicule[] = [];
  public vehicule: Vehicule = new Vehicule();

  public articleBonEntrees: ArticleBonEntree[] = [];
  public articleBonEntree: ArticleBonEntree = new ArticleBonEntree();

  public pays: Pays[] = [];
  public LePays: Pays = new Pays();



  private subscriptions: Subscription[] = [];

  constructor(

    private vehiculeService: VehiculeService,
    private matDialog: MatDialog,
    public dialogRef: MatDialogRef<VehiculeAjouterComponent>
    // @Inject(MAT_DIALOG_DATA) public data: string,
    // private matDialog: MatDialog

  ) { }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  ngOnInit(): void {

  }



  public ajouterVehicule( vehiculeForm: NgForm): void {

    // const formData = this.bonEntreeService.createBonEntreeFormData(bonEntreeForm.value);

    console.log(  vehiculeForm.value);

    this.subscriptions.push(
      this.vehiculeService.ajouterVehicule( vehiculeForm.value).subscribe({
        next: (response:   Vehicule) => {

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
