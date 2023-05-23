package ro.pao.model;

import lombok.experimental.SuperBuilder;
import  ro.pao.model.abstracts.GenericInfo;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)

public class Author extends GenericInfo {
    private List<Book> booksWritten;

    @Override
    public String toString() {
        return getClass().getSimpleName() + super.toString();
    }
}