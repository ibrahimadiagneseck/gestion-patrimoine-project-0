package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.ArticleBonEntree;

import java.util.List;

public interface ArticleBonEntreeService {

    ArticleBonEntree saveArticleBonEntree(ArticleBonEntree a);
    ArticleBonEntree updateArticleBonEntree(ArticleBonEntree a);
    void deleteArticleBonEntree(ArticleBonEntree a);
    void deleteArticleBonEntreeById(String id);
    ArticleBonEntree getArticleBonEntree(String id);
    List<ArticleBonEntree> getAllArticleBonEntrees();


}
