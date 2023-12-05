package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.Vehicule;
import sn.douanes.gestionstockpostgres.repositories.VehiculeRepository;
import sn.douanes.gestionstockpostgres.services.VehiculeService;

import java.util.List;


@Service
public class VehiculeServiceImpl implements VehiculeService {

    @Autowired
    VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule saveVehicule(Vehicule v) {
        return vehiculeRepository.save(v);
    }

    @Override
    public Vehicule updateVehicule(Vehicule v) {
        return vehiculeRepository.save(v);
    }

    @Override
    public void deleteVehicule(Vehicule v) {
        vehiculeRepository.delete(v);
    }

    @Override
    public void deleteVehiculeById(String id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule getVehiculeById(String id) {
        return vehiculeRepository.findById(id).isPresent() ? vehiculeRepository.findById(id).get() : null;
    }

    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }



}
