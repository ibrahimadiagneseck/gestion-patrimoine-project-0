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
import sn.douanes.gestionstockpostgres.entities.Controle;
import sn.douanes.gestionstockpostgres.services.ControleService;


@RestController
public class ControleController {

    @Autowired
    ControleService controleService;

    @GetMapping("/Controles")
    @ResponseBody
    public List<Controle> getAllControles() {
        return controleService.getAllControles();
    }

    @PostMapping("/AjouterControle")
    @ResponseBody
    public Controle AjouterControle(@RequestBody Controle c) {
        return controleService.saveControle(c);
    }

    @PutMapping("/ModifierControle")
    @ResponseBody
    public Controle ModifierControle(@RequestBody Controle c) {

        return controleService.updateControle(c);
    }

    @DeleteMapping("SupprimerControle/{id}")
    public void SupprimerControle(@PathVariable("id") String numeroImmatriculation ) {controleService.deleteControleById(numeroImmatriculation );}

}
