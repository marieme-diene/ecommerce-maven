package com.groupeisi.company.mapper;

import com.groupeisi.company.dto.ProduitsDto;
import com.groupeisi.company.entities.Produits;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProduitsMapper {
    
    ProduitsMapper INSTANCE = Mappers.getMapper(ProduitsMapper.class);
    
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.email", target = "userEmail")
    ProduitsDto toDto(Produits produits);
    
    @Mapping(target = "user", ignore = true)
    Produits toEntity(ProduitsDto produitsDto);
    
    List<ProduitsDto> toDtoList(List<Produits> produits);
    List<Produits> toEntityList(List<ProduitsDto> produitsDto);
}
