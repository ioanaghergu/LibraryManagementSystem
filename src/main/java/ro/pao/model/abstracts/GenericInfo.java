package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.Location;

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



    @Override
    public String toString() {
        return "[Name = " + name + "]";
    }
}
