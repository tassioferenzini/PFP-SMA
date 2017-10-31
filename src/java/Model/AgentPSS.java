package Model;

import PROV.DM.ProvAgent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "Agent")
public class AgentPSS extends ProvAgent {

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
