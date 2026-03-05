package com.groupeisi.company.mapper;

import com.groupeisi.company.dto.UsersDto;
import com.groupeisi.company.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);
    
    UsersDto toDto(Users users);
    Users toEntity(UsersDto usersDto);
    List<UsersDto> toDtoList(List<Users> users);
    List<Users> toEntityList(List<UsersDto> usersDto);
}
