package ro.pao.model.abstracts;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

// generic info about a person or a company
// used to extend the Author, Member, Librarian and Publisher classes

public abstract class GenericInfo {
    private String name;
    private String email;
    private String phoneNumber;
    private Location adress;
}
