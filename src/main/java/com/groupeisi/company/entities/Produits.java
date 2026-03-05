package com.groupeisi.company.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produits {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String ref;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private double stock;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
    
    public Produits(String ref, String name, double stock, Users user) {
        this.ref = ref;
        this.name = name;
        this.stock = stock;
        this.user = user;
    }
}
