package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.BordereauLivraison;

import java.util.List;

public interface BordereauLivraisonService {

    BordereauLivraison saveBordereauLivraison(BordereauLivraison b);
    BordereauLivraison updateBordereauLivraison(BordereauLivraison b);
    void deleteBordereauLivraison(BordereauLivraison b);
    void deleteBordereauLivraisonById(String id);
    BordereauLivraison getBordereauLivraison(String id);
    List<BordereauLivraison> getAllBordereauLivraisons();


}
