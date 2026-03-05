package com.groupeisi.company.dao;

import com.groupeisi.company.entities.Achats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AchatsRepository extends JpaRepository<Achats, Long> {
    
    List<Achats> findByUserId(Long userId);
    List<Achats> findByProductId(Long productId);
    
    @Query("SELECT a FROM Achats a WHERE a.dateP BETWEEN :startDate AND :endDate")
    List<Achats> findByDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
    @Query("SELECT a FROM Achats a WHERE a.user.id = :userId AND a.dateP BETWEEN :startDate AND :endDate")
    List<Achats> findByUserAndDateBetween(@Param("userId") Long userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
    @Query("SELECT SUM(a.quantity) FROM Achats a WHERE a.product.id = :productId")
    Double getTotalQuantityByProduct(@Param("productId") Long productId);
}
