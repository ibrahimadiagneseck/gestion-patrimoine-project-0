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
import sn.douanes.gestionstockpostgres.entities.ArticleBonPour;
import sn.douanes.gestionstockpostgres.services.ArticleBonPourService;


@RestController
public class ArticleBonPourController {

    @Autowired
    ArticleBonPourService articleBonPourService;

    @GetMapping("/ArticleBonPours")
    @ResponseBody
    public List<ArticleBonPour> getAllArticleBonPours() {
        return articleBonPourService.getAllArticleBonPours();
    }

    @PostMapping("/AjouterArticleBonPour")
    @ResponseBody
    public ArticleBonPour AjouterArticleBonPour(@RequestBody ArticleBonPour a) {
        return articleBonPourService.saveArticleBonPour(a);
    }

    @PutMapping("/ModifierArticleBonPour")
    @ResponseBody
    public ArticleBonPour ModifierArticleBonPour(@RequestBody ArticleBonPour a) {

        return articleBonPourService.updateArticleBonPour(a);
    }

    @DeleteMapping("SupprimerArticleBonPour/{id}")
    public void SupprimerArticleBonPour(@PathVariable("id") String  numeroBonPour  ) {articleBonPourService.deleteArticleBonPourById(numeroBonPour);}

}
