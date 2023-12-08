import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialogRef } from '@angular/material/dialog';
import { NotificationService } from 'src/app/services/notification.service';
import { NotificationType } from 'src/app/enum/notification-type.enum';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-reception-vehicule-ajouter',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './reception-vehicule-ajouter.component.html',
  styleUrl: './reception-vehicule-ajouter.component.css'
})
export class ReceptionVehiculeAjouterComponent implements OnInit, OnDestroy {

  private subscriptions: Subscription[] = [];

  constructor(
    public dialogRef: MatDialogRef<ReceptionVehiculeAjouterComponent>
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
    this.clickButton('submit-form');
    this.clickButton('bordereau-livraison-form');
  }



  // onSubmit(): void {
  //   // console.log(this.vehiculeForm.value);
  //   // this.AjouterVehicule();
  // }

}
