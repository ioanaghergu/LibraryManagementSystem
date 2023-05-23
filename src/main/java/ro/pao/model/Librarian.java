package ro.pao.model;

import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.GenericInfo;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)

public class Librarian extends GenericInfo {
    private Double salary;
}