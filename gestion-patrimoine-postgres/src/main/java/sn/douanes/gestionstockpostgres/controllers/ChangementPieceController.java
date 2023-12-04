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
import sn.douanes.gestionstockpostgres.entities.ChangementPiece;
import sn.douanes.gestionstockpostgres.services.ChangementPieceService;


@RestController
public class ChangementPieceController {

    @Autowired
    ChangementPieceService changementPieceService;

    @GetMapping("/ChangementPieces")
    @ResponseBody
    public List<ChangementPiece> getAllChangementPieces() {
        return changementPieceService.getAllChangementPieces();
    }

    @PostMapping("/AjouterChangementPiece")
    @ResponseBody
    public ChangementPiece AjouterChangementPiece(@RequestBody ChangementPiece c) {
        return changementPieceService.saveChangementPiece(c);
    }

    @PutMapping("/ModifierChangementPiece")
    @ResponseBody
    public ChangementPiece ModifierChangementPiece(@RequestBody ChangementPiece c) {

        return changementPieceService.updateChangementPiece(c);
    }

    @DeleteMapping("SupprimerChangementPiece/{id}")
    public void SupprimerChangementPiece(@PathVariable("id") String numeroImmatriculation ) {changementPieceService.deleteChangementPieceById(numeroImmatriculation );}

}
