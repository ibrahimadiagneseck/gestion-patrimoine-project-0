package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Agent;
import sn.douanes.gestionstockpostgres.entities.CorpsAgent;

import java.util.List;

public interface AgentService {

    Agent saveAgent(Agent a);
    Agent updateAgent(Agent a);
    void deleteAgent(Agent a);
    void deleteAgentById(String matriculeAgent, CorpsAgent codeCorpsAgent);
    Agent getAgentById(String matriculeAgent, CorpsAgent codeCorpsAgent);
    List<Agent> getAllAgents();


}
