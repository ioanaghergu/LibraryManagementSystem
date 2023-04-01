package ro.pao.model;


import ro.pao.model.enums.Status;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class BookCopy extends Book {
    private UUID copyNumber;
    private Status status;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

}
