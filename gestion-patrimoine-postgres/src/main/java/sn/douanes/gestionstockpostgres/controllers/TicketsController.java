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
import sn.douanes.gestionstockpostgres.entities.Tickets;
import sn.douanes.gestionstockpostgres.services.TicketsService;


@RestController
public class TicketsController {

    @Autowired
    TicketsService ticketsService;

    @GetMapping("/Tickets")
    @ResponseBody
    public List<Tickets> getAllTickets() {
        return ticketsService.getAllTickets();
    }

    @PostMapping("/AjouterTickets")
    @ResponseBody
    public Tickets AjouterTickets(@RequestBody Tickets t) {
        return ticketsService.saveTickets(t);
    }

    @PutMapping("/ModifierTickets")
    @ResponseBody
    public Tickets ModifierTickets(@RequestBody Tickets t) {

        return ticketsService.updateTickets(t);
    }

    @DeleteMapping("SupprimerTickets/{id}")
    public void SupprimerTickets(@PathVariable("id") Long  numero_ticket ) {ticketsService.deleteTicketsById( numero_ticket );}

}
