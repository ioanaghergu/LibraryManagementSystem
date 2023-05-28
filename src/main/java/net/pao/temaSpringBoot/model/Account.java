package net.pao.temaSpringBoot.model;

import jakarta.persistence.*;
import lombok.*;
import net.pao.temaSpringBoot.model.enums.AccountType;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "account_id")
    private UUID accountId;

    @Column(name = "balance")
    private BigDecimal balance;

    @JoinColumn(name = "client_id")
    private UUID clientId;

    @Column(name = "account_type")
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;

    @Column(name = "card_number")
    private String cardNumber;


}
