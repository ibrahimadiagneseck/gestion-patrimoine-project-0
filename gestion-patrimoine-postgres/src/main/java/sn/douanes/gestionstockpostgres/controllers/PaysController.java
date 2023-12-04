package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.Pays;
import sn.douanes.gestionstockpostgres.services.PaysService;

import java.util.List;


@RestController
public class PaysController {

    @Autowired
    PaysService paysService;

    @GetMapping("/Pays")
    @ResponseBody
    public List<Pays> getAllPays() {
        return paysService.getAllPays();
    }

    @PostMapping("/AjouterPays")
    @ResponseBody
    public Pays AjouterPays(@RequestBody Pays p) {
        return paysService.savePays(p);
    }

    @PutMapping("/ModifierPays")
    @ResponseBody
    public Pays ModifierPays(@RequestBody Pays p) {
        return paysService.updatePays(p);
    }

    @DeleteMapping("SupprimerPays/{id}")
    public void SupprimerPays(@PathVariable("id") String codePays) {
        paysService.deletePaysById(codePays);
    }

}
