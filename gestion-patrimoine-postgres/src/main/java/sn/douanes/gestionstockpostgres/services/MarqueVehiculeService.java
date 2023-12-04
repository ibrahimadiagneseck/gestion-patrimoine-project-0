package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.MarqueVehicule;

import java.util.List;

public interface MarqueVehiculeService {

    MarqueVehicule saveMarqueVehicule(MarqueVehicule m);
    MarqueVehicule updateMarqueVehicule(MarqueVehicule m);
    void deleteMarqueVehicule(MarqueVehicule m);
    void deleteMarqueVehiculeById(String id);
    MarqueVehicule getMarqueVehicule(String id);
    List<MarqueVehicule> getAllMarqueVehicules();


}
