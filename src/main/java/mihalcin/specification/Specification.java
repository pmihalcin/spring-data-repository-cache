package mihalcin.specification;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Specification {

    @Id
    private Long id;

    private final String name;

    public Specification(String name) {
        this.name = name;
    }
}
