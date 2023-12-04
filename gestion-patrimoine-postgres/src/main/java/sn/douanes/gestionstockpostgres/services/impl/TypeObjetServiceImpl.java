package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.TypeObjet;
import sn.douanes.gestionstockpostgres.repositories.TypeObjetRepository;
import sn.douanes.gestionstockpostgres.services.TypeObjetService;

import java.util.List;


@Service
public class TypeObjetServiceImpl implements TypeObjetService {

    @Autowired
    TypeObjetRepository typeObjetRepository;

    @Override
    public TypeObjet saveTypeObjet(TypeObjet t) {
        return typeObjetRepository.save(t);
    }

    @Override
    public TypeObjet updateTypeObjet(TypeObjet t) {
        return typeObjetRepository.save(t);
    }

    @Override
    public void deleteTypeObjet(TypeObjet t) {
        typeObjetRepository.delete(t);
    }

    @Override
    public void deleteTypeObjetById(String id) {
        typeObjetRepository.deleteById(id);
    }

    @Override
    public TypeObjet getTypeObjet(String id) {
        return typeObjetRepository.findById(id).get();
    }

    @Override
    public List<TypeObjet> getAllTypeObjets() {
        return typeObjetRepository.findAll();
    }



}
