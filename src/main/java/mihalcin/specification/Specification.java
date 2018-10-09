package mihalcin.specification;

import javax.persistence.Entity;

import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Specification {

    private final String name;

}
