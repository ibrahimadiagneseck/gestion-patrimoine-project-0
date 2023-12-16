package sn.douanes.gestionstockpostgres.controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.Prestataires;
import sn.douanes.gestionstockpostgres.entities.SecteurActivite;
import sn.douanes.gestionstockpostgres.services.PrestatairesService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class PrestatairesController {

    @Autowired
    PrestatairesService prestatairesService;


    @GetMapping("/Prestataires")
    public ResponseEntity<List<Prestataires>> getAllPrestataires() {
        List<Prestataires> prestataires = prestatairesService.getAllPrestataires();
        return new ResponseEntity<>(prestataires, OK);
    }

    @PostMapping("/AjouterPrestataires")
    @ResponseBody
    public ResponseEntity<Prestataires> AjouterPrestataires(@RequestBody Prestataires prestataires) {
        // Assurez-vous que SecteurActivite n'est pas null pour éviter la NullPointerException
        if (prestataires.getSecteursActivite() != null) {
            // Récupérer les entités SecteurActivite associées à Prestataires
            Set<SecteurActivite> secteurActivites = prestataires.getSecteursActivite();

            // Associer Prestataires avec chaque SecteurActivite
            for (SecteurActivite secteurActivite : secteurActivites) {
                // Assurez-vous que l'ensemble Prestataires dans SecteurActivite n'est pas null
                if (secteurActivite.getPrestataires() == null) {
                    secteurActivite.setPrestataires(new HashSet<>());
                }

                // Associer Prestataires avec SecteurActivite
                secteurActivite.getPrestataires().add(prestataires);
            }

            // Mettre à jour l'ensemble de SecteurActivite associé à l'entité Prestataires
            prestataires.setSecteursActivite(secteurActivites);
        }

        // Enregistrer l'entité Prestataires avec ses associations
        Prestataires savedPrestataires = prestatairesService.savePrestataires(prestataires);

        // Retourner l'entité Prestataires avec le statut 201 Created
        return new ResponseEntity<>(savedPrestataires, HttpStatus.CREATED);
    }


    @PostMapping("/AjouterRequestParamPrestataires")
    public ResponseEntity<Prestataires> ajouterPrestataires (
            @RequestParam("ninea") String ninea,
            @RequestParam("raisonSociale") String raisonSociale,
            @RequestParam("numeroTelephone") Integer numeroTelephone,
            @RequestParam("adresseEmail") String adresseEmail,
            @RequestParam("adresse") String adresse
    ) {
        Set<SecteurActivite> secteursActivite = new HashSet<>();
        Prestataires prestataires = prestatairesService.ajouterPrestataires(ninea, raisonSociale, numeroTelephone, adresseEmail, adresse, secteursActivite);
        return new ResponseEntity<>(prestataires, OK);
    }


    @PutMapping("/ModifierPrestataires")
    @ResponseBody
    public Prestataires ModifierPrestataires(@RequestBody Prestataires p) {

        return prestatairesService.updatePrestataires(p);
    }

    @DeleteMapping("SupprimerPrestatairesById/{id}")
    public void SupprimerPrestatairesById(@PathVariable("id") String ninea) {
        prestatairesService.deletePrestatairesById(ninea);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
