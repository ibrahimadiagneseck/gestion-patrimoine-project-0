import { Component, ElementRef, HostListener, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Vehicule } from 'src/app/model/vehicule.model';
import { VehiculeService } from 'src/app/services/vehicule.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Observable, Subject, Subscription, debounceTime, distinctUntilChanged, of, switchMap } from 'rxjs';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import jsPDF from 'jspdf';
import autoTable from 'jspdf-autotable';


@Component({
  selector: 'app-vehicule-liste',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './vehicule-liste.component.html',
  styleUrl: './vehicule-liste.component.css'
})
export class VehiculeListeComponent implements OnInit, OnDestroy {

  public vehicules: Vehicule[] = [];
  public vehicule: Vehicule | undefined;

  private subscriptions: Subscription[] = [];


  /* ----------------------------------------------------------------------------------------- */
  focusOnInput: boolean = false;

  @ViewChild('monDiv', { static: true }) monDiv: ElementRef | undefined;

  divClique(): void {
    // Code à exécuter lorsque l'élément <div> est cliqué
    // Par exemple, vous pouvez modifier une variable ou déclencher une action
    // console.log('L\'élément <div> a été cliqué !');
    this.focusOnInput = true;
  }

  @HostListener('document:click', ['$event'])
  onDocumentClick(event: Event): void {
    // Vérifie si le clic a eu lieu en dehors de l'élément monDiv
    if (!this.monDiv?.nativeElement.contains(event.target)) {
      // Code à exécuter lorsque le clic est en dehors de monDiv
      // console.log('Clic en dehors de monDiv détecté.');
      this.focusOnInput = false;
    }
  }
  /* ----------------------------------------------------------------------------------------- */
  

  /* ----------------------------------------------------------------------------------------- */
  @ViewChild('myInputSearch') myInputSearch!: ElementRef;
  // rechercher
  searchTerms = new Subject<string>();
  vehicules$: Observable<Vehicule[]> = of();
  // recherche custom
  searchTermsFilterDoubleNumeroSerieModele = new Subject<string>();
  termeRechercheNumeroSerieModele: string = "";
  vehiculeFilterDoubleNumeroSerieModele$: Observable<Vehicule[]> = of();
  /* ----------------------------------------------------------------------------------------- */


  /* ----------------------------------------------------------------------------------------- */
  // tableau
  rowNumber!: number; // numéro de ligne pour le tableau
  columnsDateFormat: string[] = [
    "dateMiseEnCirculation"
  ];
  columnsToHide: string[] = [
    "codeTypeVehicule",
    "codeMarque",
    "codeUniteDouaniere",
    "matriculeAgent",
    "codeTypeObjet",
    "provenance",
    "identifiantBE"
  ];
  dataSource = new MatTableDataSource<Vehicule>();
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  displayedColumns: string[] = [
    "N°",
    "numeroSerie",
    "codeTypeVehicule",
    "numeroImmatriculation",
    "genre",
    "codeMarque",
    "modele",
    "etatVehicule",
    "typeEnergie",
    "provenance",
    "numeroCarteGrise",
    "dateMiseEnCirculation",
    "codeUniteDouaniere",
    "matriculeAgent",
    "codeTypeObjet",
    "identifiantBE",
  ];
  displayedColumnsCustom: string[] = [
    "N°",
    "N° serie",
    "Code type vehicule",
    "N° immatriculation",
    "Genre",
    "Code marque",
    "Modele",
    "Etat vehicule",
    "Type energie",
    "Provenance",
    "N° carte grise",
    "Date mise en circulation",
    "Code unite douaniere",
    "Matricule agent",
    "Code type objet",
    "Identifiant BE",
  ];
  /* ----------------------------------------------------------------------------------------- */

  constructor(
    private vehiculeService: VehiculeService,
    private matDialog: MatDialog,
  ) { }
  
  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  ngOnInit(): void {
    this.listeVehicules();

    /* ----------------------------------------------------------------------------------------- */
    // rechercher
    this.vehicules$ = this.searchTerms.pipe(
      // {...."ab"..."abz"."ab"...."abc"......}
      debounceTime(300),
      // {......"ab"...."ab"...."abc"......}
      distinctUntilChanged(),
      // {......"ab"..........."abc"......}
      switchMap((term) => this.vehiculeService.searchVehiculeList(term, this.vehicules))
      // {.....List(ab)............List(abc)......}
    );
    this.vehiculeFilterDoubleNumeroSerieModele$ = this.searchTermsFilterDoubleNumeroSerieModele.pipe(
      // {...."ab"..."abz"."ab"...."abc"......}
      debounceTime(300),
      // {......"ab"...."ab"...."abc"......}
      distinctUntilChanged(),
      // {......"ab"..........."abc"......}
      switchMap((term) => this.vehiculeService.searchVehiculeListFilterDouble(term, this.vehicules))
      // {.....List(ab)............List(abc)......}
    );
    /* ----------------------------------------------------------------------------------------- */
  }


  generatePDF(): void {

    const data: Vehicule[] = this.dataSource.filteredData;

    // console.log(data);
    

    const months = ['JANV.', 'FÉVR.', 'MARS', 'AVR.', 'MAI', 'JUIN', 'JUIL.', 'AOÛT', 'SEPT.', 'OCT.', 'NOV.', 'DÉC.'];

    const doc = new jsPDF();

    // Créez un tableau de données pour autoTable
    const tableData = data.map((item: Vehicule) => [
      item.rowNumber,
      item.numeroSerie,
      item.codeTypeVehicule,
      item.numeroImmatriculation,
      item.genre,
      item.codeMarque.libelleMarque,
      item.modele,
      item.etatVehicule,
      item.typeEnergie,
      item.codePays.libellePays,
      item.numeroCarteGrise,
      `${new Date(item.dateMiseEnCirculation).getDate()} ${months[new Date(item.dateMiseEnCirculation).getMonth()]} ${new Date(item.dateMiseEnCirculation).getFullYear() % 100}`,
      item.codeUniteDouaniere.codeUniteDouaniere,
      item.matriculeAgent.matriculeAgent,
      item.codeTypeObjet.libelleTypeObjet,
      item.identifiantBE.identifiantBE.identifiantBE
    ]);

    // Configuration pour le PDF avec une taille de page personnalisée
 
    const marginLeft = 10;
    const marginTop = 10;
    const marginRight = 10;
    const marginBottom = 10;

    // Générer le tableau dans le PDF avec des styles de texte personnalisés
    autoTable(doc, {
      head: [
        [
          { content: 'N°', styles: { fontSize: 6 } },
          { content: 'N° serie', styles: { fontSize: 6 } },
          { content: 'Code type vehicule', styles: { fontSize: 6 } },
          { content: 'N° immatriculation', styles: { fontSize: 6 } },
          { content: 'Genre', styles: { fontSize: 6 } },
          { content: 'Code marque', styles: { fontSize: 6 } },
          { content: 'Modele', styles: { fontSize: 6 } },
          { content: 'Etat vehicule', styles: { fontSize: 6 } },
          { content: 'Type energie', styles: { fontSize: 6 } },
          { content: 'Provenance', styles: { fontSize: 6 } },
          { content: 'N° carte grise', styles: { fontSize: 6 } },
          { content: 'Date mise en circulation', styles: { fontSize: 6 } },
          { content: 'Code uniteDouaniere', styles: { fontSize: 6 } },
          { content: 'Matricule agent', styles: { fontSize: 6 } },
          { content: 'Code type objet', styles: { fontSize: 6 } },
          { content: 'Identifiant BE', styles: { fontSize: 6 } }
        ]
      ],
      body: tableData.map(row => row.map(cell => ({ content: cell.toString(), styles: { fontSize: 6 } }))),
      margin: { top: marginTop, right: marginRight, bottom: marginBottom, left: marginLeft },
      theme: 'plain'
    });

    doc.save('vehicule-liste.pdf');
  }


  search(term: string): void {
    this.termeRechercheNumeroSerieModele = term;
    this.searchTerms.next(term);
    this.searchTermsFilterDoubleNumeroSerieModele.next(term);
  }

  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

  }


  FilterDoubleNumeroSerieModele(termeRechercheNumeroSerieModele: string) {
    this.termeRechercheNumeroSerieModele = termeRechercheNumeroSerieModele;
    this.myInputSearch.nativeElement.value = termeRechercheNumeroSerieModele;
    this.dataSource.filter = termeRechercheNumeroSerieModele.trim().toLowerCase(); // supprimer les espaces vide et mettre minuscule
    this.focusOnInput = false;
  }


  isNumber(termeRechercheNumeroSerieModele: string): boolean {
    return !isNaN(Number(termeRechercheNumeroSerieModele))
  }


  public listeVehicules(): void {

    const subscription = this.vehiculeService.listeVehicules().subscribe({
      next: (response: Vehicule[]) => {
        
        // console.log(response);
        

        // this.vehicules = response.sort((a, b) => parseInt(a.numeroImmatriculation) - parseInt(b.numeroImmatriculation));
        this.vehicules = response.sort((a, b) => Number(a.numeroImmatriculation) - Number(b.numeroImmatriculation));
        // this.vehicules = response.sort((a, b) => a.numeroImmatriculation.localeCompare(b.numeroImmatriculation));
        // this.vehicules = response.sort((a, b) => a.numeroChassis - b.numeroChassis);
        // this.vehicules = response.sort((a, b) => new Date(b.dateModification).getTime() - new Date(a.dateModification).getTime());

        this.rowNumber = 1;

        // for (let i = 0; i < this.vehicules.length; i++) {
        //   this.dataSourceVehicules[i].numeroSerie = this.vehicules[i].numeroSerie;
        //   this.dataSourceVehicules[i].codeTypeVehicule = this.vehicules[i].codeTypeVehicule;
        //   this.dataSourceVehicules[i].numeroImmatriculation = this.vehicules[i].numeroImmatriculation;
        //   this.dataSourceVehicules[i].genre = this.vehicules[i].genre;
        //   this.dataSourceVehicules[i].codeMarque = this.vehicules[i].codeMarque.libelleMarque;
        //   this.dataSourceVehicules[i].modele = this.vehicules[i].modele;
        //   this.dataSourceVehicules[i].etatVehicule = this.vehicules[i].etatVehicule;
        //   this.dataSourceVehicules[i].typeEnergie = this.vehicules[i].typeEnergie;
        //   this.dataSourceVehicules[i].codePays = this.vehicules[i].codePays.libellePays;
        //   this.dataSourceVehicules[i].numeroCarteGrise = this.vehicules[i].numeroCarteGrise;
        //   this.dataSourceVehicules[i].dateMiseEnCirculation = this.vehicules[i].dateMiseEnCirculation;
        //   this.dataSourceVehicules[i].codeUniteDouaniere = this.vehicules[i].codeUniteDouaniere.codeUniteDouaniere;
        //   this.dataSourceVehicules[i].matriculeAgent = this.vehicules[i].matriculeAgent.matriculeAgent;
        //   this.dataSourceVehicules[i].codeTypeObjet = this.vehicules[i].codeTypeObjet.libelleTypeObjet;
        //   this.dataSourceVehicules[i].identifiantBE = this.vehicules[i].identifiantBE.identifiantBE;
        // }

        // this.dataSource = new MatTableDataSource<IVehicule>(this.vehicules);
        this.dataSource = new MatTableDataSource<Vehicule>(this.vehicules.map((item) => ({
          ...item,
          rowNumber: this.rowNumber++
        })));

        // console.log(this.dataSource.data);
        this.dataSource.paginator = this.paginator;
      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }



  

  popupAjouter(): void {
    const dialogRef = this.matDialog.open(
      VehiculeListeComponent,
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

  popupDetail(element: any): void {
    const dialogRef = this.matDialog.open(
      VehiculeListeComponent,
      {
        width: '80%',
        enterAnimationDuration: '100ms',
        exitAnimationDuration: '100ms',
        data: element
      }
    );

    dialogRef.afterClosed().subscribe(() => {
      this.ngOnInit();
    });
  }

}
