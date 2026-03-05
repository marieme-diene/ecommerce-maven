package com.groupeisi.company.mapper;

import com.groupeisi.company.dto.AchatsDto;
import com.groupeisi.company.entities.Achats;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AchatsMapper {
    
    AchatsMapper INSTANCE = Mappers.getMapper(AchatsMapper.class);
    
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.ref", target = "productRef")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.email", target = "userEmail")
    AchatsDto toDto(Achats achats);
    
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "user", ignore = true)
    Achats toEntity(AchatsDto achatsDto);
    
    List<AchatsDto> toDtoList(List<Achats> achats);
    List<Achats> toEntityList(List<AchatsDto> achatsDto);
}
