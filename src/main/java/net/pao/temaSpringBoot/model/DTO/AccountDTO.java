package net.pao.temaSpringBoot.model.DTO;

import lombok.*;
import net.pao.temaSpringBoot.model.enums.AccountType;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountDTO {
    private UUID accountId;
    private BigDecimal balance;
    private UUID clientId;
    private AccountType accountType;

    private String cardNumber;
}
