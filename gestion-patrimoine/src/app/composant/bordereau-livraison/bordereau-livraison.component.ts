import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
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
import { MyDate } from 'src/app/model/date.model';

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

  public sections: Sections[] = [];
  public section: Sections = new Sections();

  public agents: Agent[] = [];
  public agent: Agent = new Agent();

  private subscriptions: Subscription[] = [];

  constructor(
    private prestatairesService: PrestatairesService,
    private bordereauLivraisonService: BordereauLivraisonService,
    private sectionsService: SectionsService,
    private agentService: AgentService
  ) { }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  ngOnInit(): void {
    this.listePrestataires();
    this.listeAgent();
    this.listeSections();
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

  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeSections(): void {

    const subscription = this.sectionsService.listeSections().subscribe({
      next: (response: Sections[]) => {
        this.sections = response;
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

  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeAgent(): void {

    const subscription = this.agentService.listeAgents().subscribe({
      next: (response: Agent[]) => {
        this.agents = response;
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

    // -------------------------------------------------------------------------- METHODE 1
    // const formData = this.bordereauLivraisonService.createBordereauLivraisonFormData(bordereauLivraisonForm.value);

    // this.subscriptions.push(this.bordereauLivraisonService.ajouterBordereauLivraisonRequestParam(formData).subscribe({
    //     next: (response: BordereauLivraison) => {
    //       console.log(response);
          
    //     },
    //     error: (errorResponse: HttpErrorResponse) => {

    //     }
    //   })
    // );

    // -------------------------------------------------------------------------- METHODE 2
    const dateBL: MyDate = bordereauLivraisonForm.value.dateBL;
    const formattedDate = this.bordereauLivraisonService.formatterMyDate(dateBL);

    // const bordereauLivraisonForm1: NgForm = bordereauLivraisonForm;
    // bordereauLivraisonForm.control.get('dateBL')?.patchValue(formattedDate);
    // bordereauLivraisonForm.control.get('dateBL')?.setValue(formattedDate);
    
    const bordereauLivraison: any = bordereauLivraisonForm.value;
    if (formattedDate) {
      bordereauLivraison.dateBL = formattedDate;
    }
    
    console.log(bordereauLivraison);
    

    this.subscriptions.push(this.bordereauLivraisonService.ajouterBordereauLivraison(bordereauLivraisonForm.value).subscribe({
        next: (response: BordereauLivraison) => {
          
        },
        error: (errorResponse: HttpErrorResponse) => {

        }
      })
    );

  }

  // --------------------------------------------------------------------------

}