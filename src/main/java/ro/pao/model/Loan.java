package ro.pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Loan {
    private UUID id;
    private UUID id_issuer;
    private UUID id_receiver;
    private UUID id_member;
    private UUID id_copy;

}

