package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.SecteurActivite;

import java.util.List;

public interface SecteurActiviteService {

    SecteurActivite saveSecteurActivite(SecteurActivite s);
    SecteurActivite updateSecteurActivite(SecteurActivite s);
    void deleteSecteurActivite(SecteurActivite s);
    void deleteSecteurActiviteById(String id);
    SecteurActivite getSecteurActiviteById(String id);
    List<SecteurActivite> getAllSecteurActivites();


}
