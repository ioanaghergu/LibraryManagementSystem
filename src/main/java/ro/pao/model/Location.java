package ro.pao.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@SuperBuilder(toBuilder = true)

public class Location {
    private String country;
    private String city;
    private String street;
    private Integer apartment;
    private Integer streetNumber;

}