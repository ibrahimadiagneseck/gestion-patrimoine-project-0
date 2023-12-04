package sn.douanes.gestionstockpostgres.entities.keys;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import sn.douanes.gestionstockpostgres.entities.CorpsAgent;

import java.io.Serializable;

public class AgentId implements Serializable {

    private String matriculeAgent;

    private String codeCorpsAgent;

    public AgentId() {
    }

    public AgentId(String matriculeAgent, String codeCorpsAgent) {
        this.matriculeAgent = matriculeAgent;
        this.codeCorpsAgent = codeCorpsAgent;
    }
}
