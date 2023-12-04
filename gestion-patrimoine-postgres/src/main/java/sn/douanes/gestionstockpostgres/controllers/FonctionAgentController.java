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
import sn.douanes.gestionstockpostgres.entities.FonctionAgent;
import sn.douanes.gestionstockpostgres.services.FonctionAgentService;


@RestController
public class FonctionAgentController {

    @Autowired
    FonctionAgentService fonctionAgentService;

    @GetMapping("/FonctionAgents")
    @ResponseBody
    public List<FonctionAgent> getAllFonctionAgents() {
        return fonctionAgentService.getAllFonctionAgents();
    }

    @PostMapping("/AjouterFonctionAgent")
    @ResponseBody
    public FonctionAgent AjouterFonctionAgent(@RequestBody FonctionAgent f) {
        return fonctionAgentService.saveFonctionAgent(f);
    }

    @PutMapping("/ModifierFonctionAgent")
    @ResponseBody
    public FonctionAgent ModifierFonctionAgent(@RequestBody FonctionAgent f) {

        return fonctionAgentService.updateFonctionAgent(f);
    }

    @DeleteMapping("SupprimerFonctionAgent/{id}")
    public void SupprimerFonctionAgent(@PathVariable("id") String codeFonctionAgent ) {fonctionAgentService.deleteFonctionAgentById(codeFonctionAgent);}

}
