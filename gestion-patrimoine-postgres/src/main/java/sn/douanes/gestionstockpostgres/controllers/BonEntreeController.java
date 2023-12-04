package sn.douanes.gestionstockpostgres.controllers;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.services.BonEntreeService;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping(path = { "/", "/BonEntree"})
//@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
public class BonEntreeController {

    @Autowired
    BonEntreeService bonEntreeService;

    @GetMapping("/BonEntrees")
    public ResponseEntity<List<BonEntree>> getAllBonEntrees() {
        List<BonEntree> bonEntrees = bonEntreeService.getAllBonEntrees();
        return new ResponseEntity<>(bonEntrees, OK);
    }


//    @PostMapping("/AjouterBonEntree")
//    @ResponseBody
//    public BonEntree AjouterBonEntree(@RequestBody BonEntree b) {
//        return bonEntreeService.saveBonEntree(b);
//    }

//    @PostMapping("/AjouterBonEntree")
//    public ResponseEntity<BonEntree> ajouterBonEntree(
//                                                      @RequestParam("numeroBE") String numeroBE,
//                                                      @RequestParam("libelleBonEntree") String libelleBonEntree,
//                                                      @RequestParam("dateBonEntree") Date dateBonEntree,
//                                                      @RequestParam("observationBonEntree") String observationBonEntree,
//                                                      @RequestParam("identifiantBL") BordereauLivraison identifiantBL,
//                                                      @RequestParam("matriculeAgent") Agent matriculeAgent,
//                                                      @RequestParam("codeSection") Sections codeSection
//
//    ) {
//        BonEntree bonEntree = bonEntreeService.ajouterBonEntree(numeroBE,  libelleBonEntree,  dateBonEntree, observationBonEntree, identifiantBL,  matriculeAgent,  codeSection);
//        return new ResponseEntity<>(bonEntree, OK);
//    }


    @PostMapping("/AjouterBonEntree")
    @ResponseBody
    public ResponseEntity<BonEntree> ajouterBonEntree(
            @RequestBody BonEntree b

    ) {
        BonEntree bonEntree = bonEntreeService.ajouterBonEntree(b.getNumeroBE(),  b.getLibelleBonEntree(),  b.getDateBonEntree(), b.getObservationBonEntree(), b.getIdentifiantBL(),  b.getMatriculeAgent(),  b.getCodeSection());
        return new ResponseEntity<>(bonEntree, OK);
    }


    @PutMapping("/ModifierBonEntree")
    @ResponseBody
    public BonEntree ModifierBonEntree(@RequestBody BonEntree b) {
        return bonEntreeService.updateBonEntree(b);
    }

    @DeleteMapping("SupprimerBonEntree/{id}")
    public void SupprimerBonEntree(@PathVariable("id") String identifiantBE) {bonEntreeService.deleteBonEntreeById(identifiantBE);}


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }
}
