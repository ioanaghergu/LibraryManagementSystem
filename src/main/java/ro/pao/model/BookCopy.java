package ro.pao.model;


import lombok.experimental.SuperBuilder;
import ro.pao.model.enums.Status;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)

public class BookCopy extends Book {
    private UUID id;
    private Status status;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[Title = " + getTitle() +  "\n" +
                                              "Status = " + status  + "]";
    }

}