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
import sn.douanes.gestionstockpostgres.entities.BonPour;
import sn.douanes.gestionstockpostgres.services.BonPourService;


@RestController
public class BonPourController {

    @Autowired
    BonPourService bonPourService;

    @GetMapping("/BonPours")
    @ResponseBody
    public List<BonPour> getAllBonPours() {
        return bonPourService.getAllBonPours();
    }

    @PostMapping("/AjouterBonPour")
    @ResponseBody
    public BonPour AjouterBonPour(@RequestBody BonPour b) {
        return bonPourService.saveBonPour(b);
    }

    @PutMapping("/ModifierBonPour")
    @ResponseBody
    public BonPour ModifierBonPour(@RequestBody BonPour b) {

        return bonPourService.updateBonPour(b);
    }

    @DeleteMapping("SupprimerBonPour/{id}")
    public void SupprimerBonPour(@PathVariable("id") String numeroBonPour) {bonPourService.deleteBonPourById(numeroBonPour);}

}
