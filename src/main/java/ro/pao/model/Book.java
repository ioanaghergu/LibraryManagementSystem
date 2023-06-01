package ro.pao.model;

import lombok.experimental.SuperBuilder;
import ro.pao.model.enums.Genre;
import ro.pao.model.enums.Section;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
//@ToString
@SuperBuilder(toBuilder = true)

public class Book {

    private UUID id;
    private UUID id_author;
    private UUID id_publisher;
    private String title;
    private Genre genre;
    private Section section;
    private LocalDate publicationDate;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[Title = " + title + "]";

    }

}