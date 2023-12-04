package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.MarqueVehicule;
import sn.douanes.gestionstockpostgres.repositories.MarqueVehiculeRepository;
import sn.douanes.gestionstockpostgres.services.MarqueVehiculeService;

import java.util.List;


@Service
public class MarqueVehiculeServiceImpl implements MarqueVehiculeService {

    @Autowired
    MarqueVehiculeRepository marqueVehiculeRepository;

    @Override
    public MarqueVehicule saveMarqueVehicule(MarqueVehicule t) {
        return marqueVehiculeRepository.save(t);
    }

    @Override
    public MarqueVehicule updateMarqueVehicule(MarqueVehicule t) {
        return marqueVehiculeRepository.save(t);
    }

    @Override
    public void deleteMarqueVehicule(MarqueVehicule t) {
        marqueVehiculeRepository.delete(t);
    }

    @Override
    public void deleteMarqueVehiculeById(String id) {
        marqueVehiculeRepository.deleteById(id);
    }

    @Override
    public MarqueVehicule getMarqueVehicule(String id) {
        return marqueVehiculeRepository.findById(id).get();
    }

    @Override
    public List<MarqueVehicule> getAllMarqueVehicules() {
        return marqueVehiculeRepository.findAll();
    }



}
