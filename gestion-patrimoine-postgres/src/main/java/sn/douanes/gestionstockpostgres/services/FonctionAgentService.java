package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.FonctionAgent;

import java.util.List;

public interface FonctionAgentService {

    FonctionAgent saveFonctionAgent(FonctionAgent f);
    FonctionAgent updateFonctionAgent(FonctionAgent f);
    void deleteFonctionAgent(FonctionAgent f);
    void deleteFonctionAgentById(String id);
    FonctionAgent getFonctionAgent(String id);
    List<FonctionAgent> getAllFonctionAgents();


}
