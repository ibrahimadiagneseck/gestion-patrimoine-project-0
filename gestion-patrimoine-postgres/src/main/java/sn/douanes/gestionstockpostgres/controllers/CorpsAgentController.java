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
import sn.douanes.gestionstockpostgres.entities.CorpsAgent;
import sn.douanes.gestionstockpostgres.services.CorpsAgentService;


@RestController
public class CorpsAgentController {

    @Autowired
    CorpsAgentService corpsAgentService;

    @GetMapping("/CorpsAgents")
    @ResponseBody
    public List<CorpsAgent> getAllCorpsAgents() {
        return corpsAgentService.getAllCorpsAgents();
    }

    @PostMapping("/AjouterCorpsAgent")
    @ResponseBody
    public CorpsAgent AjouterCorpsAgent(@RequestBody CorpsAgent c) {
        return corpsAgentService.saveCorpsAgent(c);
    }

    @PutMapping("/ModifierCorpsAgent")
    @ResponseBody
    public CorpsAgent ModifierCorpsAgent(@RequestBody CorpsAgent c) {

        return corpsAgentService.updateCorpsAgent(c);
    }

    @DeleteMapping("SupprimerCorpsAgent/{id}")
    public void SupprimerCorpsAgent(@PathVariable("id") String codeCorpsAgent) {corpsAgentService.deleteCorpsAgentById(codeCorpsAgent);}

}
