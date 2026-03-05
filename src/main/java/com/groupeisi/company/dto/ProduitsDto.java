package com.groupeisi.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitsDto {
    
    private Long id;
    private String ref;
    private String name;
    private double stock;
    private Long userId;
    private String userEmail;
}
