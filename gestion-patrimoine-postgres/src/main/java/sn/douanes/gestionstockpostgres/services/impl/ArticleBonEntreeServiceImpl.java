package sn.douanes.gestionstockpostgres.services.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.Agent;
import sn.douanes.gestionstockpostgres.entities.ArticleBonEntree;
import sn.douanes.gestionstockpostgres.entities.BonEntree;
import sn.douanes.gestionstockpostgres.entities.TypeObjet;
import sn.douanes.gestionstockpostgres.entities.keys.ArticleBonEntreeId;
import sn.douanes.gestionstockpostgres.repositories.ArticleBonEntreeRepository;
import sn.douanes.gestionstockpostgres.services.ArticleBonEntreeService;


@Service
public class ArticleBonEntreeServiceImpl implements ArticleBonEntreeService {

    @Autowired
    ArticleBonEntreeRepository articleBonEntreeRepository;

    @Override
    public ArticleBonEntree saveArticleBonEntree(ArticleBonEntree a) {
        return articleBonEntreeRepository.save(a);
    }

    @Override
    public ArticleBonEntree updateArticleBonEntree(ArticleBonEntree a) {
        return articleBonEntreeRepository.save(a);
    }

    @Override
    public void deleteArticleBonEntree(ArticleBonEntree a) {
        articleBonEntreeRepository.delete(a);
    }

    @Override
    public void deleteArticleBonEntreeById(BonEntree identifiantBE, Integer codeArticleBonEntree) {
        articleBonEntreeRepository.deleteById(new ArticleBonEntreeId(identifiantBE, codeArticleBonEntree));
    }

    @Override
    public ArticleBonEntree getArticleBonEntreeById(BonEntree identifiantBE, Integer codeArticleBonEntree) {
        return articleBonEntreeRepository.findById(new ArticleBonEntreeId(identifiantBE, codeArticleBonEntree)).get();
    }

    @Override
    public List<ArticleBonEntree> getAllArticleBonEntrees() {
        return articleBonEntreeRepository.findAll();
    }


    @Override
    public ArticleBonEntree ajouterArticleBonEntree(
            BonEntree identifiantBE,
            Integer codeArticleBonEntree,
            String libelleArticleBonEntree,
            Integer quantiteEntree,
            TypeObjet codeTypeObjet,
            Agent matriculeAgent
    ) {

        ArticleBonEntree articleBonEntree = new ArticleBonEntree();

        articleBonEntree.setDateEnregistrement(new Timestamp(System.currentTimeMillis()));

        articleBonEntree.setIdentifiantBE(identifiantBE);
        articleBonEntree.setCodeArticleBonEntree(codeArticleBonEntree);
        articleBonEntree.setLibelleArticleBonEntree(libelleArticleBonEntree);
        articleBonEntree.setQuantiteEntree(quantiteEntree);
        articleBonEntree.setCodeTypeObjet(codeTypeObjet);
        articleBonEntree.setMatriculeAgent(matriculeAgent);

        return articleBonEntreeRepository.save(articleBonEntree);
    }


}
