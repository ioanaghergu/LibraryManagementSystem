package ro.pao.model;

import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.GenericInfo;
import ro.pao.model.Location;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)

public class Publisher extends GenericInfo {
    private List<Book> publishedBooks;
    private Location adress;
}