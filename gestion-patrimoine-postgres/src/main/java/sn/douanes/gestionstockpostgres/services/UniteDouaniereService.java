package sn.douanes.gestionstockpostgres.services;


import sn.douanes.gestionstockpostgres.entities.UniteDouaniere;


import java.util.List;

public interface UniteDouaniereService {

    UniteDouaniere saveUniteDouaniere(UniteDouaniere u);
    UniteDouaniere updateUniteDouaniere(UniteDouaniere u);
    void deleteUniteDouaniere(UniteDouaniere u);
    void deleteUniteDouaniereById(String id);
    UniteDouaniere getUniteDouaniere(String id);
    List<UniteDouaniere> getAllUniteDouanieres();





}
