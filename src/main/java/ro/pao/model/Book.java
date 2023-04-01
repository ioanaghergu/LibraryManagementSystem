package ro.pao.model;

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
@ToString
@EqualsAndHashCode

public class Book {

    private UUID id;
    private String title;
    private Genre genre;
    private Section section;
    private Publisher publisher;
    private LocalDate publicationDate;
    private List<Author> authors;
    private Integer copies;

}