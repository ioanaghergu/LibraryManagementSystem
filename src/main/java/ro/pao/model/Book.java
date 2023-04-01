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
@ToString
@EqualsAndHashCode
@SuperBuilder(toBuilder = true)

public class Book implements Comparable<Book> {

    private UUID id;
    private String title;
    private Genre genre;
    private Section section;
    private Publisher publisher;
    private LocalDate publicationDate;
    private List<Author> authors;
    private Integer copies;

    @Override
    public int compareTo(Book book) {
        return publicationDate.compareTo(book.publicationDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[ Title = " + title + "\n" +
                "Genre = " + genre + "\n" +
                "Section = " + section + "\n" +
                "Publisher = " + publisher + "\n" +
                "Publication Date = " + publicationDate + "\n" +
                "Number of copies = " + copies + "\n" +
                "List of authors = " + authors + "] \n";
    }

}