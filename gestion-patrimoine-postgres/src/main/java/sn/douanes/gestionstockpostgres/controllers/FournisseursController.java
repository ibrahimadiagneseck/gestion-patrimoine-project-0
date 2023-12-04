package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sn.douanes.gestionstockpostgres.entities.Fournisseurs;
import sn.douanes.gestionstockpostgres.services.FournisseursService;


@RestController
public class FournisseursController {

    @Autowired
    FournisseursService fournisseursService;

    @GetMapping("/Fournisseurs")
    @ResponseBody
    public List<Fournisseurs> getAllFournisseurs() {
        return fournisseursService.getAllFournisseurs();
    }

    @PostMapping("/AjouterFournisseurs")
    @ResponseBody
    public Fournisseurs AjouterFournisseurs(@RequestBody Fournisseurs f) {
        return fournisseursService.saveFournisseurs(f);
    }

    @PutMapping("/ModifierFournisseurs")
    @ResponseBody
    public Fournisseurs ModifierFournisseurs(@RequestBody Fournisseurs f) {

        return fournisseursService.updateFournisseurs(f);
    }

    @DeleteMapping("SupprimerFournisseurs/{id}")
    public void SupprimerFournisseurs(@PathVariable("id") String codeFournisseur) {fournisseursService.deleteFournisseursById(codeFournisseur );}

}
