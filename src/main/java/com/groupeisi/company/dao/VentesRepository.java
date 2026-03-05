package com.groupeisi.company.dao;

import com.groupeisi.company.entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VentesRepository extends JpaRepository<Ventes, Long> {
    
    List<Ventes> findByUserId(Long userId);
    List<Ventes> findByProductId(Long productId);
    
    @Query("SELECT v FROM Ventes v WHERE v.dateP BETWEEN :startDate AND :endDate")
    List<Ventes> findByDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
    @Query("SELECT v FROM Ventes v WHERE v.user.id = :userId AND v.dateP BETWEEN :startDate AND :endDate")
    List<Ventes> findByUserAndDateBetween(@Param("userId") Long userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
    @Query("SELECT SUM(v.quantity) FROM Ventes v WHERE v.product.id = :productId")
    Double getTotalQuantityByProduct(@Param("productId") Long productId);
}
