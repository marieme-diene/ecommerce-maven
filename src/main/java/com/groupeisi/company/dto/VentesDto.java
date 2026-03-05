package com.groupeisi.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentesDto {
    
    private Long id;
    private Date dateP;
    private double quantity;
    private Long productId;
    private String productRef;
    private String productName;
    private Long userId;
    private String userEmail;
}
