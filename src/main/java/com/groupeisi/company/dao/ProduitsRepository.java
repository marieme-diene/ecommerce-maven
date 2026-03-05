package com.groupeisi.company.dao;

import com.groupeisi.company.entities.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProduitsRepository extends JpaRepository<Produits, Long> {
    
    Optional<Produits> findByRef(String ref);
    boolean existsByRef(String ref);
    
    List<Produits> findByUserId(Long userId);
    
    @Query("SELECT p FROM Produits p WHERE p.stock > 0")
    List<Produits> findAvailableProducts();
    
    @Query("SELECT p FROM Produits p WHERE p.name LIKE %:name%")
    List<Produits> findByNameContaining(@Param("name") String name);
}
