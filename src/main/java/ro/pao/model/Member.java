package ro.pao.model;

import ro.pao.model.abstracts.GenericInfo;
import ro.pao.model.abstracts.Location;
import ro.pao.model.enums.MemberType;
import lombok.*;


import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Member extends GenericInfo {
    private MemberType memberType;
    private Location adress;
    private List<BookCopy> borrowedBooks;
    private List<BookCopy> returnedBooks;

}
