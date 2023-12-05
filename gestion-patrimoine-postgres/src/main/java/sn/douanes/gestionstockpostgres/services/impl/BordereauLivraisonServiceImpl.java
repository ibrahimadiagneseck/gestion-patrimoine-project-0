package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.BordereauLivraison;
import sn.douanes.gestionstockpostgres.repositories.BordereauLivraisonRepository;
import sn.douanes.gestionstockpostgres.services.BordereauLivraisonService;


@Service
public class BordereauLivraisonServiceImpl implements BordereauLivraisonService {

    @Autowired
    BordereauLivraisonRepository bordereauLivraisonRepository;

    @Override
    public BordereauLivraison saveBordereauLivraison(BordereauLivraison b) {
        return bordereauLivraisonRepository.save(b);
    }

    @Override
    public BordereauLivraison updateBordereauLivraison(BordereauLivraison b) {
        return bordereauLivraisonRepository.save(b);
    }

    @Override
    public void deleteBordereauLivraison(BordereauLivraison b) {
        bordereauLivraisonRepository.delete(b);
    }

    @Override
    public void deleteBordereauLivraisonById(String id) {
        bordereauLivraisonRepository.deleteById(id);
    }

    @Override
    public BordereauLivraison getBordereauLivraisonById(String id) {
        return bordereauLivraisonRepository.findById(id).isPresent() ? bordereauLivraisonRepository.findById(id).get() : null;
    }

    @Override
    public List<BordereauLivraison> getAllBordereauLivraisons() {
        return bordereauLivraisonRepository.findAll();
    }



}
