package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.TypeObjet;

import java.util.List;

public interface TypeObjetService {

    TypeObjet saveTypeObjet(TypeObjet t);
    TypeObjet updateTypeObjet(TypeObjet t);
    void deleteTypeObjet(TypeObjet t);
    void deleteTypeObjetById(String id);
    TypeObjet getTypeObjet(String id);
    List<TypeObjet> getAllTypeObjets();


}
