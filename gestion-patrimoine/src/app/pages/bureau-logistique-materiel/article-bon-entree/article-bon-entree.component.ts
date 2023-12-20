import { Component, OnDestroy, OnInit } from '@angular/core';
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
import { Agent } from 'src/app/model/agent.model';
import { BonEntreeService } from 'src/app/services/bon-entree.service';
import { TypeObjetService } from 'src/app/services/type-objet.service';
import { AgentService } from 'src/app/services/agent.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-article-bon-entree',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './article-bon-entree.component.html',
  styleUrl: './article-bon-entree.component.css'
})
export class ArticleBonEntreeComponent implements OnInit, OnDestroy {



  private subscriptions: Subscription[] = [];

  constructor(
    private router: Router,

  ) { }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  ngOnInit(): void {

  }



  // --------------------------------------------------------------------------

  private clickButton(buttonId: string): void {
    document.getElementById(buttonId)?.click();
  }

  // pour envoyer tous les formulaires
  public submitForm(): void { 
    this.clickButton('article-bon-entree-form');
    this.clickButton('vehicule-form');
  }



  // onSubmit(): void {
  //   // console.log(this.vehiculeForm.value);
  //   // this.AjouterVehicule();
  // }

}

