package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.TypeUniteDouaniere;

import java.util.List;

public interface TypeUniteDouaniereService {

    TypeUniteDouaniere saveTypeUniteDouaniere(TypeUniteDouaniere t);
    TypeUniteDouaniere updateTypeUniteDouaniere(TypeUniteDouaniere t);
    void deleteTypeUniteDouaniere(TypeUniteDouaniere t);
    void deleteTypeUniteDouaniereById(String id);
    TypeUniteDouaniere getTypeUniteDouaniere(String id);
    List<TypeUniteDouaniere> getAllTypeUniteDouanieres();


}
