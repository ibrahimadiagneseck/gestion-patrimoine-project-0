package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.Agent;
import sn.douanes.gestionstockpostgres.entities.BordereauLivraison;
import sn.douanes.gestionstockpostgres.services.AgentService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class AgentController {

    @Autowired
    AgentService agentService;


    @GetMapping("/Agents")
    public ResponseEntity<List<Agent>> getAllAgents() {
        List<Agent> agents = agentService.getAllAgents();
        return new ResponseEntity<>(agents, OK);
    }


    @PostMapping("/AjouterAgent")
    @ResponseBody
    public Agent AjouterAgent(@RequestBody Agent a) {
        return agentService.saveAgent(a);
    }

    @PutMapping("/ModifierAgent")
    @ResponseBody
    public Agent ModifierAgent(@RequestBody Agent a) {

        return agentService.updateAgent(a);
    }

    @DeleteMapping("SupprimerAgent/{id}")
    public void SupprimerAgent(@PathVariable("id") String matriculeAgentCodeCorpsAgent) {agentService.deleteAgentById(matriculeAgentCodeCorpsAgent);}

}
