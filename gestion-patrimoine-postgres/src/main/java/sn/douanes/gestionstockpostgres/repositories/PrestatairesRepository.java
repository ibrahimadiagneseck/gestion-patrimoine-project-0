package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.Prestataires;


@Repository
public interface PrestatairesRepository extends JpaRepository<Prestataires, String> {

}
