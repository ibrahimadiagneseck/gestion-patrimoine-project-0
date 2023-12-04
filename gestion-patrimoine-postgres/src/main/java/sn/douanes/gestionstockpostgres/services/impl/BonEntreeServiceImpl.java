package sn.douanes.gestionstockpostgres.services.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.Agent;
import sn.douanes.gestionstockpostgres.entities.BonEntree;
import sn.douanes.gestionstockpostgres.entities.BordereauLivraison;
import sn.douanes.gestionstockpostgres.entities.Sections;
import sn.douanes.gestionstockpostgres.repositories.BonEntreeRepository;
import sn.douanes.gestionstockpostgres.services.BonEntreeService;


@Service
public class BonEntreeServiceImpl implements BonEntreeService {

    @Autowired
    BonEntreeRepository bonEntreeRepository;

    @Override
    public BonEntree saveBonEntree(BonEntree b) {
        return bonEntreeRepository.save(b);
    }


    @Override
    public BonEntree updateBonEntree(BonEntree b) {
        return bonEntreeRepository.save(b);
    }

    @Override
    public void deleteBonEntree(BonEntree b) {
        bonEntreeRepository.delete(b);
    }

    @Override
    public void deleteBonEntreeById(String id) {
        bonEntreeRepository.deleteById(id);
    }

    @Override
    public BonEntree getBonEntree(String id) {
        return bonEntreeRepository.findById(id).get();
    }

    @Override
    public List<BonEntree> getAllBonEntrees() {
        return bonEntreeRepository.findAll();
    }

    @Override
    public BonEntree ajouterBonEntree(String numeroBE, String libelleBonEntree, Date dateBonEntree, String observationBonEntree, BordereauLivraison identifiantBL, Agent matriculeAgent, Sections codeSection) {
        BonEntree bonEntree = new BonEntree();

        bonEntree.setDateEnregistrement(new Timestamp(System.currentTimeMillis()));
        bonEntree.setIdentifiantBE(genererIdentifiantBE(codeSection.getCodeSection(), bonEntree.getDateEnregistrement()));
        bonEntree.setNumeroBE(numeroBE);
        bonEntree.setLibelleBonEntree(libelleBonEntree);
        bonEntree.setDateBonEntree(dateBonEntree);
        bonEntree.setObservationBonEntree(observationBonEntree);
        bonEntree.setIdentifiantBL(identifiantBL);
        bonEntree.setMatriculeAgent(matriculeAgent);
        bonEntree.setCodeSection(codeSection);


        bonEntreeRepository.save(bonEntree);
        return bonEntree;
    }


    private String genererIdentifiantBE(String codeSection, Timestamp dateEnregistrement) {
        // = new Timestamp(System.currentTimeMillis())
        return "BE" + codeSection + dateEnregistrement;
    }

}
