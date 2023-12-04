package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.CorpsAgent;

import java.util.List;

public interface CorpsAgentService {

    CorpsAgent saveCorpsAgent(CorpsAgent a);
    CorpsAgent updateCorpsAgent(CorpsAgent a);
    void deleteCorpsAgent(CorpsAgent a);
    void deleteCorpsAgentById(String id);
    CorpsAgent getCorpsAgent(String id);
    List<CorpsAgent> getAllCorpsAgents();


}

