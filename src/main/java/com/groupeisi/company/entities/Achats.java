package com.groupeisi.company.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "achats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Achats {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "date_p", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateP;
    
    @Column(nullable = false)
    private double quantity;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Produits product;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
    
    public Achats(Date dateP, double quantity, Produits product, Users user) {
        this.dateP = dateP;
        this.quantity = quantity;
        this.product = product;
        this.user = user;
    }
}
