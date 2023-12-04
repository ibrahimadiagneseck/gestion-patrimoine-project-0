package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Agent;
import sn.douanes.gestionstockpostgres.entities.BonEntree;
import sn.douanes.gestionstockpostgres.entities.BordereauLivraison;
import sn.douanes.gestionstockpostgres.entities.Sections;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface BonEntreeService {

    BonEntree saveBonEntree(BonEntree b);
    BonEntree updateBonEntree(BonEntree b);
    void deleteBonEntree(BonEntree b);
    void deleteBonEntreeById(String id);
    BonEntree getBonEntree(String id);
    List<BonEntree> getAllBonEntrees();

    BonEntree ajouterBonEntree(String numeroBE, String libelleBonEntree, Date dateBonEntree, String observationBonEntree, BordereauLivraison identifiantBL, Agent matriculeAgent, Sections codeSection) ;


}
