package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.Prestataires;
import sn.douanes.gestionstockpostgres.entities.PrestatairesSecteur;
import sn.douanes.gestionstockpostgres.entities.SecteurActivite;
import sn.douanes.gestionstockpostgres.entities.keys.PrestatairesSecteurId;
import sn.douanes.gestionstockpostgres.repositories.PrestatairesSecteurRepository;
import sn.douanes.gestionstockpostgres.services.PrestatairesSecteurService;

import java.util.List;


@Service
public class PrestatairesSecteurServiceImpl implements PrestatairesSecteurService {

    @Autowired
    PrestatairesSecteurRepository prestatairesSecteurRepository;

    @Override
    public PrestatairesSecteur savePrestatairesSecteur(PrestatairesSecteur p) {
        return prestatairesSecteurRepository.save(p);
    }

    @Override
    public PrestatairesSecteur updatePrestatairesSecteur(PrestatairesSecteur p) {
        return prestatairesSecteurRepository.save(p);
    }

    @Override
    public void deletePrestatairesSecteur(PrestatairesSecteur p) {
        prestatairesSecteurRepository.delete(p);
    }

    @Override
    public void deletePrestatairesSecteurById(Prestataires ninea, SecteurActivite codeSecteurActivite) {
        prestatairesSecteurRepository.deleteById(new PrestatairesSecteurId(ninea, codeSecteurActivite));
    }

    @Override
    public PrestatairesSecteur getPrestatairesSecteurById(Prestataires ninea, SecteurActivite codeSecteurActivite) {
        return prestatairesSecteurRepository.findById(new PrestatairesSecteurId(ninea, codeSecteurActivite)).isPresent() ? prestatairesSecteurRepository.findById(new PrestatairesSecteurId(ninea, codeSecteurActivite)).get() : null;
    }

    @Override
    public List<PrestatairesSecteur> getAllPrestatairesSecteur() {
        return prestatairesSecteurRepository.findAll();
    }


    @Override
    public PrestatairesSecteur ajouterPrestatairesSecteur(
            Prestataires ninea,
            SecteurActivite codeSecteurActivite
    ) {

        PrestatairesSecteur prestatairesSecteur = new PrestatairesSecteur();

        prestatairesSecteur.setNinea(ninea);
        prestatairesSecteur.setCodeSecteurActivite(codeSecteurActivite);


        return prestatairesSecteurRepository.save(prestatairesSecteur);
    }


}
