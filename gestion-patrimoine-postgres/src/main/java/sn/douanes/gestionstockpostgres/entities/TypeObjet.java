package sn.douanes.gestionstockpostgres.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "type_objet")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeObjet {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "code_type_objet", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "code_type_objet", length = 5)
    private String codeTypeObjet;

    @Column(name = "libelle_type_objet", length = 100)
    private String libelleTypeObjet;

    @ManyToOne
    @JoinColumn(name = "code_section")
    private Sections codeSection;

}