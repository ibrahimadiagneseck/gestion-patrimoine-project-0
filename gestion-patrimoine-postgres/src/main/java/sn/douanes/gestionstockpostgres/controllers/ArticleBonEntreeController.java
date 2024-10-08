package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.services.ArticleBonEntreeService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class ArticleBonEntreeController {

    @Autowired
    ArticleBonEntreeService articleBonEntreeService;

    
    @GetMapping("/ArticleBonEntrees")
    public ResponseEntity<List<ArticleBonEntree>> getAllArticleBonEntrees() {
        List<ArticleBonEntree> articleBonEntree = articleBonEntreeService.getAllArticleBonEntrees();
        return new ResponseEntity<>(articleBonEntree, OK);
    }

    @PostMapping("/AjouterArticleBonEntree")
    @ResponseBody
    public ArticleBonEntree AjouterArticleBonEntree(@RequestBody ArticleBonEntree articleBonEntree) {
        return articleBonEntreeService.saveArticleBonEntree(articleBonEntree);
    }

    @PostMapping("/AjouterRequestParamArticleBonEntree")
    public ResponseEntity<ArticleBonEntree> ajouterArticleBonEntree (
            @RequestParam("identifiantBE") BonEntree identifiantBE,
            @RequestParam("codeArticleBonEntree") Integer codeArticleBonEntree,
            @RequestParam("libelleArticleBonEntree") String libelleArticleBonEntree,
            @RequestParam("quantiteEntree") Integer quantiteEntree,
            @RequestParam("codeTypeObjet") TypeObjet codeTypeObjet,
            @RequestParam("matriculeAgent") Agent matriculeAgent
    ) {
        ArticleBonEntree articleBonEntree = articleBonEntreeService.ajouterArticleBonEntree(identifiantBE, codeArticleBonEntree, libelleArticleBonEntree, quantiteEntree, codeTypeObjet, matriculeAgent);
        return new ResponseEntity<>(articleBonEntree, OK);
    }

    @PutMapping("/ModifierArticleBonEntree")
    @ResponseBody
    public ArticleBonEntree ModifierArticleBonEntree(@RequestBody ArticleBonEntree a) {
        return articleBonEntreeService.updateArticleBonEntree(a);
    }

    @DeleteMapping("SupprimerArticleBonEntree/{id}")
    public void SupprimerArticleBonEntree(
            @PathVariable("identifiantBE") BonEntree identifiantBE,
            @PathVariable("codeArticleBonEntree") Integer codeArticleBonEntree
    ) {
        articleBonEntreeService.deleteArticleBonEntreeById(identifiantBE, codeArticleBonEntree);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
                httpStatus
        );
    }

}
