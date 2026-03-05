package com.groupeisi.company.mapper;

import com.groupeisi.company.dto.VentesDto;
import com.groupeisi.company.entities.Ventes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VentesMapper {
    
    VentesMapper INSTANCE = Mappers.getMapper(VentesMapper.class);
    
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.ref", target = "productRef")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.email", target = "userEmail")
    VentesDto toDto(Ventes ventes);
    
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "user", ignore = true)
    Ventes toEntity(VentesDto ventesDto);
    
    List<VentesDto> toDtoList(List<Ventes> ventes);
    List<Ventes> toEntityList(List<VentesDto> ventesDto);
}
