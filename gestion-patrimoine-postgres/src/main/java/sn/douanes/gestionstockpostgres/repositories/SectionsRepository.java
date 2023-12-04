package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.Sections;
import sn.douanes.gestionstockpostgres.entities.TypeObjet;


@Repository
public interface SectionsRepository extends JpaRepository<Sections, String> {
}
