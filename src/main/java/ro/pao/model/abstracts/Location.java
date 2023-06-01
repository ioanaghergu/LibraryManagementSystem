package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@SuperBuilder(toBuilder = true)

public abstract class Location {
    private String country;
    private String city;
    private String street;
    private Integer apartment;
    private Integer streetNumber;

}
