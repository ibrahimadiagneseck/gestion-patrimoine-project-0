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

@Component({
  selector: 'app-bon-entree',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './bon-entree.component.html',
  styleUrl: './bon-entree.component.css'
})
export class BonEntreeComponent implements OnInit, OnDestroy {

  public bonEntrees: BonEntree[] = [];
  public bonEntree: BonEntree = new BonEntree();

  public sections: Sections[] = [];
  public section: Sections = new Sections();

  public bordereauLivraisons: BordereauLivraison[] = [];
  public bordereauLivraison: BordereauLivraison = new BordereauLivraison();

  public agents: Agent[] = [];
  public agent: Agent = new Agent();

  private subscriptions: Subscription[] = [];

  constructor(
    private bonEntreeService: BonEntreeService,
    private sectionsService: SectionsService,
    private bordereauLivraisonService: BordereauLivraisonService,
    private agentService: AgentService
  ) { }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  ngOnInit(): void {
    this.listeSections();
    this.listeBordereauLivraisons();
    this.listeAgents();
  }

  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeSections(): void {

    const subscription = this.sectionsService.listeSections().subscribe({
      next: (response: Sections[]) => {
        this.sections = response;
        // console.log(this.sections);
        
      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }
  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------

  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeBordereauLivraisons(): void {

    const subscription = this.bordereauLivraisonService.listeBordereauLivraisons().subscribe({
      next: (response: BordereauLivraison[]) => {
        this.bordereauLivraisons = response;
        // console.log(this.bordereauLivraisons);
        
      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }
  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------

  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeAgents(): void {

    const subscription = this.agentService.listeAgents().subscribe({
      next: (response: Agent[]) => {
        this.agents = response;
        // console.log(this.agents);
        
      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }
  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------

  // public ajouterBonEntree(bonEntreeForm: NgForm): void {

  //   const formData = this.bonEntreeService.createBonEntreeFormData(bonEntreeForm.value);

  //   console.log(formData);

  //   this.subscriptions.push(
  //     this.bonEntreeService.ajouterBonEntree(formData).subscribe({
  //       next: (response: BonEntree) => {

  //       },
  //       error: (errorResponse: HttpErrorResponse) => {

  //       }
  //     })
  //   );
  // }

  public ajouterBonEntree(bonEntreeForm: NgForm): void {

    // const formData = this.bonEntreeService.createBonEntreeFormData(bonEntreeForm.value);

    console.log(bonEntreeForm.value);

    this.subscriptions.push(
      this.bonEntreeService.ajouterBonEntree(bonEntreeForm.value).subscribe({
        next: (response: BonEntree) => {

        },
        error: (errorResponse: HttpErrorResponse) => {

        }
      })
    );
  }

}