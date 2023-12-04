package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.Agent;
import sn.douanes.gestionstockpostgres.entities.Vehicule;
import sn.douanes.gestionstockpostgres.repositories.AgentRepository;
import sn.douanes.gestionstockpostgres.services.AgentService;


@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentRepository agentRepository;

    @Override
    public Agent saveAgent(Agent a) {
        return agentRepository.save(a);
    }

    @Override
    public Agent updateAgent(Agent a) {
        return agentRepository.save(a);
    }

    @Override
    public void deleteAgent(Agent a) {
        agentRepository.delete(a);
    }

    @Override
    public void deleteAgentById(String id) {
        agentRepository.deleteById(id);
    }

    @Override
    public Agent getAgent(String id) {
        return agentRepository.findById(id).get();
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }



}
