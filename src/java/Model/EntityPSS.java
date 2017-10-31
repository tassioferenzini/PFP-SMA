package Model;

import PROV.DM.ProvEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 *
 * @author tassio
 */
@javax.persistence.Entity
@Table(name = "Entity")
public class EntityPSS extends ProvEntity {

    @Column
    private String title;
    @Column
    private int price;

    public EntityPSS() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
