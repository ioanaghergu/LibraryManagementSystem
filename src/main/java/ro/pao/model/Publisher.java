package ro.pao.model;

import ro.pao.model.abstracts.GenericInfo;
import ro.pao.model.abstracts.Location;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Publisher extends GenericInfo {
    private List<Book> publishedBooks;
    private Location adress;
}
