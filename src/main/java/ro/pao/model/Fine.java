package ro.pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Fine {
    private Double fineValue;
    private Member member;
    private List<BookCopy> returnedLateBooks;

}