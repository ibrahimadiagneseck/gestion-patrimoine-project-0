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
import sn.douanes.gestionstockpostgres.entities.Maintenance;
import sn.douanes.gestionstockpostgres.services.MaintenanceService;


@RestController
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/Maintenances")
    @ResponseBody
    public List<Maintenance> getAllMaintenances() {
        return maintenanceService.getAllMaintenances();
    }

    @PostMapping("/AjouterMaintenance")
    @ResponseBody
    public Maintenance AjouterMaintenance(@RequestBody Maintenance m) {
        return maintenanceService.saveMaintenance(m);
    }

    @PutMapping("/ModifierMaintenance")
    @ResponseBody
    public Maintenance ModifierMaintenance(@RequestBody Maintenance m) {

        return maintenanceService.updateMaintenance(m);
    }

    @DeleteMapping("SupprimerMaintenance/{id}")
    public void SupprimerMaintenance(@PathVariable("id") String maintenance ) {maintenanceService.deleteMaintenanceById(maintenance);}

}
