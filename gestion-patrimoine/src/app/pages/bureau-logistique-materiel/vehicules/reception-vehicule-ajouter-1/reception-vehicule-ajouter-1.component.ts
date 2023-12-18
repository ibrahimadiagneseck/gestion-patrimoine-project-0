import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { NotificationService } from 'src/app/services/notification.service';
import { NotificationType } from 'src/app/enum/notification-type.enum';
import { Subscription } from 'rxjs';
import { ReceptionVehiculeAjouter2Component } from '../reception-vehicule-ajouter-2/reception-vehicule-ajouter-2.component';

@Component({
  selector: 'app-reception-vehicule-ajouter-1',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './reception-vehicule-ajouter-1.component.html',
  styleUrl: './reception-vehicule-ajouter-1.component.css'
})
export class ReceptionVehiculeAjouter1Component implements OnInit, OnDestroy {

  private subscriptions: Subscription[] = [];

  constructor(
    private matDialog: MatDialog,
    public dialogRef: MatDialogRef<ReceptionVehiculeAjouter1Component>
  ) {}


  ngOnInit(): void {

  }


  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  popupFermer(): void {
    this.dialogRef.close();
  }


  // --------------------------------------------------------------------------

  private clickButton(buttonId: string): void {
    document.getElementById(buttonId)?.click();
  }

  // pour envoyer tous les formulaires
  public submitForm(): void { 
    this.clickButton('bordereau-livraison-form');
    this.clickButton('bon-entree-form');
  }


  popupAjouterArticleBonEntreeVehicule(): void {

    this.dialogRef.close();

    const dialogRef = this.matDialog.open(
      ReceptionVehiculeAjouter2Component,
      {
        width: '80%',
        enterAnimationDuration: '100ms',
        exitAnimationDuration: '100ms'
      }
    );

    dialogRef.afterClosed().subscribe(() => {
      this.ngOnInit();
    });
  }

  // onSubmit(): void {
  //   // console.log(this.vehiculeForm.value);
  //   // this.AjouterVehicule();
  // }

}
