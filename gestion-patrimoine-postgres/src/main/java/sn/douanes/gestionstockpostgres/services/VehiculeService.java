package sn.douanes.gestionstockpostgres.services;


import sn.douanes.gestionstockpostgres.entities.*;

import java.util.Date;
import java.util.List;

public interface VehiculeService {

    Vehicule saveVehicule(Vehicule v);
    Vehicule updateVehicule(Vehicule v);
    void deleteVehicule(Vehicule v);
    void deleteVehiculeById(String id);
    Vehicule getVehiculeById(String id);
    List<Vehicule> getAllVehicules();


    Vehicule ajouterVehicule(String numeroSerie, String numeroImmatriculation, String genre, String modele, String etatVehicule, String typeEnergie, String numeroCarteGrise, Date dateMiseEnCirculation, Pays codePays, TypeVehicule codeTypeVehicule, MarqueVehicule codeMarque, UniteDouaniere codeUniteDouaniere, ArticleBonEntree identifiantBE);


}
