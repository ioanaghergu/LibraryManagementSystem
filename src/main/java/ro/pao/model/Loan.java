package ro.pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Loan {
    private Librarian issuer;
    private Librarian receiver;
    private Member member;
    private BookCopy book;

}
