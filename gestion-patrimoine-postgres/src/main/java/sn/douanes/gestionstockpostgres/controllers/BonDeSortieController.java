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
import sn.douanes.gestionstockpostgres.entities.BonDeSortie;
import sn.douanes.gestionstockpostgres.services.BonDeSortieService;


@RestController
public class BonDeSortieController {

    @Autowired
    BonDeSortieService bonDeSortieService;

    @GetMapping("/BonDeSorties")
    @ResponseBody
    public List<BonDeSortie> getAllBonDeSorties() {
        return bonDeSortieService.getAllBonDeSorties();
    }

    @PostMapping("/AjouterBonDeSortie")
    @ResponseBody
    public BonDeSortie AjouterBonDeSortie(@RequestBody BonDeSortie b) {
        return bonDeSortieService.saveBonDeSortie(b);
    }

    @PutMapping("/ModifierBonDeSortie")
    @ResponseBody
    public BonDeSortie ModifierBonDeSortie(@RequestBody BonDeSortie b) {

        return bonDeSortieService.updateBonDeSortie(b);
    }

    @DeleteMapping("SupprimerBonDeSortie/{id}")
    public void SupprimerBonDeSortie(@PathVariable("id") String numeroBonSortie) {bonDeSortieService.deleteBonDeSortieById(numeroBonSortie);}

}
