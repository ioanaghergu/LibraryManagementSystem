package ro.pao.model;

import  ro.pao.model.abstracts.GenericInfo;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)

public class Author extends GenericInfo {
    private List<Book> booksWritten;

}