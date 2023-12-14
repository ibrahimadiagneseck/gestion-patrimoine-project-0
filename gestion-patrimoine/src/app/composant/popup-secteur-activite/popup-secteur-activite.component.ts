import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormGroup } from '@angular/forms';
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




  popupFermer(): void {
    this.dialogRef.close();
  }




  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }


}