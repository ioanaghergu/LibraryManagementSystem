package net.pao.temaSpringBoot.model.DTO;

import jakarta.persistence.*;
import lombok.*;
import net.pao.temaSpringBoot.model.Account;
import net.pao.temaSpringBoot.model.enums.ClientType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientDTO {
    private UUID clientId;
    private String lastName;
    private String firstName;
    private LocalDate birthdate;
    private String birthPlace;
    private String email;
    private ClientType clientType;
    private List<Account> accountId;

}
