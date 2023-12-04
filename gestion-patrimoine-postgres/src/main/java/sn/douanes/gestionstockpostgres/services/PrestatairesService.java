package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Prestataires;

import java.util.List;

public interface PrestatairesService {

    Prestataires savePrestataires(Prestataires p);
    Prestataires updatePrestataires(Prestataires p);
    void deletePrestataires(Prestataires p);
    void deletePrestatairesById(String id);
    Prestataires getPrestataires(String id);
    List<Prestataires> getAllPrestataires();


}
