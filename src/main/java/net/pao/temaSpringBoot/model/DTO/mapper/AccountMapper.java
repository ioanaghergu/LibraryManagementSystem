package net.pao.temaSpringBoot.model.DTO.mapper;

import net.pao.temaSpringBoot.model.Account;
import net.pao.temaSpringBoot.model.DTO.AccountDTO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(source = "accountId", target = "accountId")
    @Mapping(source = "balance", target = "balance")
    @Mapping(source = "clientId", target = "clientId")
    @Mapping(source = "accountType", target = "accountType")
    @Mapping(source = "cardNumber", target = "cardNumber")
    AccountDTO accountToDTO(Account account);

    @Mapping(source = "accountId", target = "accountId")
    @Mapping(source = "balance", target = "balance")
    @Mapping(source = "clientId", target = "clientId")
    @Mapping(source = "accountType", target = "accountType")
    @Mapping(source = "cardNumber", target = "cardNumber")
    Account dtoToAccount(AccountDTO accountDTO);
}
