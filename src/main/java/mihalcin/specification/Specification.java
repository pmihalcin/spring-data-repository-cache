package mihalcin.specification;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Specification {

    @Id
    private Long id;

    private final String name;

}
