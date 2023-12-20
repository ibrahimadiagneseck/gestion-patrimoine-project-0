import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialogRef } from '@angular/material/dialog';
import { NotificationService } from 'src/app/services/notification.service';
import { NotificationType } from 'src/app/enum/notification-type.enum';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-reception-vehicule-ajouter-2',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './reception-vehicule-ajouter-2.component.html',
  styleUrl: './reception-vehicule-ajouter-2.component.css'
})
export class ReceptionVehiculeAjouter2Component implements OnInit, OnDestroy {


  afficherPopupArticleBonEntree: boolean = true;

  private subscriptions: Subscription[] = [];

  constructor(
    public dialogRef: MatDialogRef<ReceptionVehiculeAjouter2Component>
  ) {}


  ngOnInit(): void {
    
  }


  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  popupFermer(): void {
    this.dialogRef.close();
  }


  popupVehicule(): void {
    this.afficherPopupArticleBonEntree = false;
  }


  popupArticleBonEntree(): void {
    this.afficherPopupArticleBonEntree = true;
  }
  

  // --------------------------------------------------------------------------

  private clickButton(buttonId: string): void {
    document.getElementById(buttonId)?.click();
  }

  // pour envoyer tous les formulaires
  public submitForm(): void { 
    this.clickButton('article-bon-entre-form');
    this.clickButton('vehicule-form');
  }



  // onSubmit(): void {
  //   // console.log(this.vehiculeForm.value);
  //   // this.AjouterVehicule();
  // }

}
