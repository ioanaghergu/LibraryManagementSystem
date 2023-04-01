package ro.pao.model;

import ro.pao.model.abstracts.GenericInfo;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Librarian extends GenericInfo {
    private Double salary;
}