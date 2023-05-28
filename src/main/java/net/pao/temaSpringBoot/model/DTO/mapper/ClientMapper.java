package net.pao.temaSpringBoot.model.DTO.mapper;

import net.pao.temaSpringBoot.model.Client;
import net.pao.temaSpringBoot.model.DTO.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);


    @Mapping(source = "clientId", target = "clientId")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "birthdate", target = "birthdate")
    @Mapping(source = "birthPlace", target = "birthPlace")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "clientType", target = "clientType")
    @Mapping(source = "accountId", target = "accountId")
    ClientDTO clientToDTO(Client client);

    @Mapping(source = "clientId", target = "clientId")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "birthdate", target = "birthdate")
    @Mapping(source = "birthPlace", target = "birthPlace")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "clientType", target = "clientType")
    @Mapping(source = "accountId", target = "accountId")
    Client dtoToClient(ClientDTO clientDTO);

}
