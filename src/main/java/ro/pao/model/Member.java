package ro.pao.model;

import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.GenericInfo;
import ro.pao.model.Location;
import ro.pao.model.enums.MemberType;
import lombok.*;


import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)

public class Member extends GenericInfo {
    private MemberType memberType;
    private Location adress;
    private List<BookCopy> borrowedBooks;
    private List<BookCopy> returnedBooks;

    @Override
    public String toString() {
        return getClass().getSimpleName() + super.toString() + "\n" +

                "Member Type = " + memberType + "\n";
    }

}

