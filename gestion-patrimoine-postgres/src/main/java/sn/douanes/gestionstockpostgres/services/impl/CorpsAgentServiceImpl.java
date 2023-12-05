package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.CorpsAgent;
import sn.douanes.gestionstockpostgres.repositories.CorpsAgentRepository;
import sn.douanes.gestionstockpostgres.services.CorpsAgentService;


@Service
public class CorpsAgentServiceImpl implements CorpsAgentService {

    @Autowired
    CorpsAgentRepository corpsAgentRepository;

    @Override
    public CorpsAgent saveCorpsAgent(CorpsAgent c) {
        return corpsAgentRepository.save(c);
    }

    @Override
    public CorpsAgent updateCorpsAgent(CorpsAgent c) {
        return corpsAgentRepository.save(c);
    }

    @Override
    public void deleteCorpsAgent(CorpsAgent c) {
        corpsAgentRepository.delete(c);
    }

    @Override
    public void deleteCorpsAgentById(String id) {
        corpsAgentRepository.deleteById(id);
    }

    @Override
    public CorpsAgent getCorpsAgentById(String id) {
        return corpsAgentRepository.findById(id).isPresent() ? corpsAgentRepository.findById(id).get() : null;
    }

    @Override
    public List<CorpsAgent> getAllCorpsAgents() {
        return corpsAgentRepository.findAll();
    }



}
