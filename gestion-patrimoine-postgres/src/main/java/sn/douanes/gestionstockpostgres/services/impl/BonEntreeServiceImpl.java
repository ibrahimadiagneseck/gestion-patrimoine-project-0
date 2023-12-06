package sn.douanes.gestionstockpostgres.services.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
    public BonEntree getBonEntreeById(String id) {
        return bonEntreeRepository.findById(id).isPresent() ? bonEntreeRepository.findById(id).get() : null;
    }

    @Override
    public List<BonEntree> getAllBonEntrees() {
        return bonEntreeRepository.findAll();
    }

    @Override
    public BonEntree ajouterBonEntree(
            String numeroBE,
            String libelleBonEntree,
            Date dateBonEntree,
            String observationBonEntree,
            BordereauLivraison identifiantBL
    ) {

        BonEntree bonEntree = new BonEntree();

        bonEntree.setDateEnregistrement(new SimpleDateFormat("yyyyMMddHHmmssSSS"));
        bonEntree.setIdentifiantBE(genererIdentifiantBE(bonEntree.getIdentifiantBL(), bonEntree.getDateEnregistrement()));

        bonEntree.setNumeroBE(numeroBE);
        bonEntree.setLibelleBonEntree(libelleBonEntree);
        bonEntree.setDateBonEntree(dateBonEntree);
        bonEntree.setObservationBonEntree(observationBonEntree);
        bonEntree.setIdentifiantBL(identifiantBL);


        return bonEntreeRepository.save(bonEntree);
    }


    private String genererIdentifiantBE(BordereauLivraison bordereauLivraison, SimpleDateFormat dateEnregistrement) {
        // Timestamp t = new Timestamp(System.currentTimeMillis())
        return "BE" + bordereauLivraison.getCodeSection() + dateEnregistrement;
    }


}
