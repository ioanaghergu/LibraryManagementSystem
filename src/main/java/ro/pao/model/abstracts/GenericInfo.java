package ro.pao.model.abstracts;

import ro.pao.model.Location;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@SuperBuilder(toBuilder = true)

// generic info about a person or a company
// used to extend the Author, Member, Librarian and Publisher classes

public abstract class GenericInfo {
    private UUID id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location adress;

    /*
    protected GenericInfo(String country, String city, String street, int apartment, int streetNumber) {
        this.adress.setCountry(country);
        this.adress.setCity(city);
        this.adress.setStreet(street);
        this.adress.setApartment(apartment);
        this.adress.setStreetNumber(streetNumber);
    }
     */

    @Override
    public String toString() {
        return "[Name = " + name + "]";
    }

}