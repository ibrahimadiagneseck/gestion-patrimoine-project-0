package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Agent;

import java.util.List;

public interface AgentService {

    Agent saveAgent(Agent a);
    Agent updateAgent(Agent a);
    void deleteAgent(Agent a);
    void deleteAgentById(String id);
    Agent getAgent(String id);
    List<Agent> getAllAgents();


}
