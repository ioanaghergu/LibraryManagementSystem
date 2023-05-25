package ro.pao.model;

import lombok.experimental.SuperBuilder;
import  ro.pao.model.abstracts.GenericInfo;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)

public class Author extends GenericInfo {
    @Override
    public String toString() {
        return getClass().getSimpleName() + super.toString();
    }
}