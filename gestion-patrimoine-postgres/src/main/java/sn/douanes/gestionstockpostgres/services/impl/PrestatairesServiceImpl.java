package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.Prestataires;
import sn.douanes.gestionstockpostgres.repositories.PrestatairesRepository;
import sn.douanes.gestionstockpostgres.services.PrestatairesService;

import java.util.List;


@Service
public class PrestatairesServiceImpl implements PrestatairesService {

    @Autowired
    PrestatairesRepository prestatairesRepository;

    @Override
    public Prestataires savePrestataires(Prestataires p) {
        return prestatairesRepository.save(p);
    }

    @Override
    public Prestataires updatePrestataires(Prestataires p) {
        return prestatairesRepository.save(p);
    }

    @Override
    public void deletePrestataires(Prestataires p) {
        prestatairesRepository.delete(p);
    }

    @Override
    public void deletePrestatairesById(String id) {
        prestatairesRepository.deleteById(id);
    }

    @Override
    public Prestataires getPrestatairesById(String id) {
        return prestatairesRepository.findById(id).isPresent() ? prestatairesRepository.findById(id).get() : null;
    }

    @Override
    public List<Prestataires> getAllPrestataires() {
        return prestatairesRepository.findAll();
    }



}
