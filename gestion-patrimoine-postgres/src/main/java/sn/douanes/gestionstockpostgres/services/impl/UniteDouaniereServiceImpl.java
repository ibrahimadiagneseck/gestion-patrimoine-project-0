package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.UniteDouaniere;
import sn.douanes.gestionstockpostgres.repositories.UniteDouaniereRepository;
import sn.douanes.gestionstockpostgres.services.UniteDouaniereService;


@Service
public class UniteDouaniereServiceImpl implements UniteDouaniereService {

    @Autowired
    UniteDouaniereRepository uniteDouaniereRepository;

    @Override
    public UniteDouaniere saveUniteDouaniere(UniteDouaniere u) {
        return uniteDouaniereRepository.save(u);
    }

    @Override
    public UniteDouaniere updateUniteDouaniere(UniteDouaniere u) {
        return uniteDouaniereRepository.save(u);
    }

    @Override
    public void deleteUniteDouaniere(UniteDouaniere u) {
        uniteDouaniereRepository.delete(u);
    }

    @Override
    public void deleteUniteDouaniereById(String id) {
        uniteDouaniereRepository.deleteById(id);
    }

    @Override
    public UniteDouaniere getUniteDouaniereById(String id) {
        return uniteDouaniereRepository.findById(id).isPresent() ? uniteDouaniereRepository.findById(id).get() : null;
    }

    @Override
    public List<UniteDouaniere> getAllUniteDouanieres() {
        return uniteDouaniereRepository.findAll();
    }



}
