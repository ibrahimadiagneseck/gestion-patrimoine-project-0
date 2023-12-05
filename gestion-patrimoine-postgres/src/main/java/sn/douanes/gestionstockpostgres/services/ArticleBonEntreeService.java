package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.ArticleBonEntree;
import sn.douanes.gestionstockpostgres.entities.BonEntree;

import java.util.List;

public interface ArticleBonEntreeService {

    ArticleBonEntree saveArticleBonEntree(ArticleBonEntree a);
    ArticleBonEntree updateArticleBonEntree(ArticleBonEntree a);
    void deleteArticleBonEntree(ArticleBonEntree a);
    void deleteArticleBonEntreeById(BonEntree identifiantBE, Integer codeArticleBonEntree);
    ArticleBonEntree getArticleBonEntreeById(BonEntree identifiantBE, Integer codeArticleBonEntree);
    List<ArticleBonEntree> getAllArticleBonEntrees();


}
