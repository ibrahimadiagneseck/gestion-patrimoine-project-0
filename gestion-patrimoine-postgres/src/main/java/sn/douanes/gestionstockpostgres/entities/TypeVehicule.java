package sn.douanes.gestionstockpostgres.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "type_vehicule")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeVehicule {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "code_type_vehicule", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "code_type_vehicule", length = 25)
    private String codeTypeVehicule;

    @Column(name = "libelle_type_vehicule", length = 100)
    private String libelleTypeVehicule;
}