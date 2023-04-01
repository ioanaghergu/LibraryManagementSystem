package ro.pao.model.abstracts;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public abstract class Location {
    private String country;
    private String city;
    private String street;
    private Integer apartment;
    private Integer number;

}
