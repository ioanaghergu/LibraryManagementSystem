package net.pao.temaSpringBoot.model;

import jakarta.persistence.*;
import lombok.*;
import net.pao.temaSpringBoot.model.enums.ClientType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "email")
    private String email;

    @Column(name = "client_type")
    @Enumerated(value = EnumType.STRING)
    private ClientType clientType;

    @OneToMany
    @JoinColumn(name = "account_id")
    private List<Account> accountId;


}
