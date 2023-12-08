import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgForm } from '@angular/forms';
import { BonEntree } from 'src/app/model/bon-entree.model';
import { HttpErrorResponse } from '@angular/common/http';
import { BonEntreeService } from 'src/app/services/bon-entree.service';
import { Subscription } from 'rxjs';
import { BordereauLivraison } from 'src/app/model/bordereau-livraison.model';
import { Sections } from 'src/app/model/sections.model';
import { Agent } from 'src/app/model/agent.model';
import { SectionsService } from 'src/app/services/sections.service';
import { BordereauLivraisonService } from 'src/app/services/bordereau-livraison.service';
import { AgentService } from 'src/app/services/agent.service';
import { Prestataires } from 'src/app/model/prestataires.model';
import { PrestatairesService } from 'src/app/services/prestataires.service';

@Component({
  selector: 'app-bordereau-livraison',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './bordereau-livraison.component.html',
  styleUrl: './bordereau-livraison.component.css'
})
export class BordereauLivraisonComponent implements OnInit, OnDestroy {


  public prestataires: Prestataires[] = [];
  public prestataire: Prestataires = new Prestataires();

  private subscriptions: Subscription[] = [];

  constructor(
    private prestatairesService: PrestatairesService,
    private bordereauLivraisonService: BordereauLivraisonService
  ) { }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  ngOnInit(): void {
    this.listePrestataires();
  }



  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listePrestataires(): void {

    const subscription = this.prestatairesService.listePrestataires().subscribe({
      next: (response: Prestataires[]) => {
        this.prestataires = response;
        // console.log(this.prestataires);
        
      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }
  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------



  // --------------------------------------------------------------------------

  private clickButton(buttonId: string): void {
    document.getElementById(buttonId)?.click();
  }

  // pour executer ajouterBordereauLivraison
  public submitBordereauLivraisonForm(): void { 
    this.clickButton('bordereau-livraison-form')
  }

  public ajouterBordereauLivraison(bordereauLivraisonForm: NgForm): void {

    const formData = this.bordereauLivraisonService.createBordereauLivraisonFormData(bordereauLivraisonForm.value);
    console.log(bordereauLivraisonForm.value);

    this.subscriptions.push(
      this.bordereauLivraisonService.ajouterBordereauLivraisonRequestParam(formData).subscribe({
        next: (response: BordereauLivraison) => {

        },
        error: (errorResponse: HttpErrorResponse) => {

        }
      })
    );
  }

  // --------------------------------------------------------------------------


}