package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.BonEntree;
import sn.douanes.gestionstockpostgres.entities.CorpsAgent;
import sn.douanes.gestionstockpostgres.entities.FonctionAgent;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.services.FonctionAgentService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class FonctionAgentController {

    @Autowired
    FonctionAgentService fonctionAgentService;


    @GetMapping("/FonctionAgents")
    public ResponseEntity<List<FonctionAgent>> getAllFonctionAgents() {
        List<FonctionAgent> fonctionAgent = fonctionAgentService.getAllFonctionAgents();
        return new ResponseEntity<>(fonctionAgent, OK);
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
    public void SupprimerFonctionAgent(@PathVariable("id") String codeFonctionAgent ) {
        fonctionAgentService.deleteFonctionAgentById(codeFonctionAgent);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
