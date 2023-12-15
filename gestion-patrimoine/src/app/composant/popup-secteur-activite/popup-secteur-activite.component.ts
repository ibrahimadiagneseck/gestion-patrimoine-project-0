import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormArray, FormControl, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { SecteurActivite } from 'src/app/model/secteur-activite.model';
import { Subscription } from 'rxjs';
import { Prestataires } from 'src/app/model/prestataires.model';


@Component({
  selector: 'app-popup-secteur-activite',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './popup-secteur-activite.component.html',
  styleUrl: './popup-secteur-activite.component.css'
})
export class PopupSecteurActiviteComponent implements OnInit, OnDestroy {

  checkArray: FormArray | undefined;
  public secteurActiviteForm!: FormGroup;
  

  public secteurActivites: SecteurActivite[] = [];
  public secteurActivite: SecteurActivite = new SecteurActivite();

  public prestataires: Prestataires[] = [];
  public prestataire: Prestataires = new Prestataires();


  private subscriptions: Subscription[] = [];

  constructor(
    public dialogRef: MatDialogRef<PopupSecteurActiviteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { secteurActivites: SecteurActivite[], prestataire: Prestataires },
    private matDialog: MatDialog

  ) { }




  ngOnInit(): void {
    this.secteurActivites = this.data.secteurActivites;
    this.prestataire  = this.data.prestataire; 
    // console.log(this.secteurActivites);
  }


  validerSecteurActivites(): void {

    // if(this.checkArray && this.checkArray.controls) {
    //   let valeur;
    //   for (let i = 0; i < this.checkArray.length; i++) {
    //     if (this.checkArray.controls[i] instanceof FormControl) {
    //       valeur = this.checkArray.controls[i].value;
    //       console.log(valeur);
    //       this.tolaService.AjouterUtilisateurThemeById(this.utilisateur.idutilisateur, valeur).subscribe(
    //         () => {
    //           console.log(this.utilisateur.idutilisateur);
    //         },
    //         (erreurs: HttpErrorResponse) => {
    //           console.log(erreurs);
    //         }
    //       );
    //       this.goToConnexion();
    //     }
    //   }
    // } else {
    //   this.goToConnexion();
    // }
  }


  onCheckboxChange(event: any) {

    this.checkArray = this.secteurActiviteForm.get('checkArray') as FormArray;

    if (event.target.checked) {
      if (this.checkArray) {
        this.checkArray.push(new FormControl(event.target.value));
        console.log(this.checkArray.value);
      }
    } else {
      const index = this.checkArray.controls
        .findIndex(x => x.value === event.target.value);
      this.checkArray.removeAt(index);
      console.log(this.checkArray.value);
    }
  }


  popupFermer(): void {
    this.dialogRef.close();
  }



  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }


}