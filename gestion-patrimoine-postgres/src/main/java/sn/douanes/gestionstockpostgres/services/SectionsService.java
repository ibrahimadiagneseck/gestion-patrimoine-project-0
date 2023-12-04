package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Sections;

import java.util.List;

public interface SectionsService {

    Sections saveSections(Sections s);
    Sections updateSections(Sections s);
    void deleteSections(Sections s);
    void deleteSectionsById(String id);
    Sections getSections(String id);
    List<Sections> getAllSectionss();


}
