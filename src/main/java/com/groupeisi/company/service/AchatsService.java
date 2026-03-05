package com.groupeisi.company.service;

import com.groupeisi.company.dto.AchatsDto;
import com.groupeisi.company.entities.Achats;
import com.groupeisi.company.mapper.AchatsMapper;
import com.groupeisi.company.dao.AchatsRepository;
import com.groupeisi.company.dao.ProduitsRepository;
import com.groupeisi.company.dao.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AchatsService {
    
    private final AchatsRepository achatsRepository;
    private final ProduitsRepository produitsRepository;
    private final UsersRepository usersRepository;
    private final AchatsMapper achatsMapper;
    
    public List<AchatsDto> findAll() {
        log.info("Finding all purchases");
        List<Achats> achats = achatsRepository.findAll();
        return achatsMapper.toDtoList(achats);
    }
    
    public Optional<AchatsDto> findById(Long id) {
        log.info("Finding purchase by id: {}", id);
        return achatsRepository.findById(id)
                .map(achatsMapper::toDto);
    }
    
    public List<AchatsDto> findByUserId(Long userId) {
        log.info("Finding purchases by user id: {}", userId);
        List<Achats> achats = achatsRepository.findByUserId(userId);
        return achatsMapper.toDtoList(achats);
    }
    
    public List<AchatsDto> findByProductId(Long productId) {
        log.info("Finding purchases by product id: {}", productId);
        List<Achats> achats = achatsRepository.findByProductId(productId);
        return achatsMapper.toDtoList(achats);
    }
    
    public List<AchatsDto> findByDateBetween(Date startDate, Date endDate) {
        log.info("Finding purchases between {} and {}", startDate, endDate);
        List<Achats> achats = achatsRepository.findByDateBetween(startDate, endDate);
        return achatsMapper.toDtoList(achats);
    }
    
    @Transactional
    public AchatsDto save(AchatsDto achatsDto) {
        log.info("Saving purchase for product: {}", achatsDto.getProductId());
        
        Achats achats = achatsMapper.toEntity(achatsDto);
        
        if (achatsDto.getProductId() != null) {
            produitsRepository.findById(achatsDto.getProductId())
                    .ifPresent(achats::setProduct);
        }
        
        if (achatsDto.getUserId() != null) {
            usersRepository.findById(achatsDto.getUserId())
                    .ifPresent(achats::setUser);
        }
        
        if (achats.getDateP() == null) {
            achats.setDateP(new Date());
        }
        
        Achats savedAchats = achatsRepository.save(achats);
        return achatsMapper.toDto(savedAchats);
    }
    
    @Transactional
    public AchatsDto update(Long id, AchatsDto achatsDto) {
        log.info("Updating purchase with id: {}", id);
        return achatsRepository.findById(id)
                .map(existingAchat -> {
                    existingAchat.setDateP(achatsDto.getDateP());
                    existingAchat.setQuantity(achatsDto.getQuantity());
                    
                    if (achatsDto.getProductId() != null) {
                        produitsRepository.findById(achatsDto.getProductId())
                                .ifPresent(existingAchat::setProduct);
                    }
                    
                    if (achatsDto.getUserId() != null) {
                        usersRepository.findById(achatsDto.getUserId())
                                .ifPresent(existingAchat::setUser);
                    }
                    
                    Achats updatedAchat = achatsRepository.save(existingAchat);
                    return achatsMapper.toDto(updatedAchat);
                })
                .orElseThrow(() -> new RuntimeException("Purchase not found with id: " + id));
    }
    
    public void deleteById(Long id) {
        log.info("Deleting purchase with id: {}", id);
        if (!achatsRepository.existsById(id)) {
            throw new RuntimeException("Purchase not found with id: " + id);
        }
        achatsRepository.deleteById(id);
    }
    
    public Double getTotalQuantityByProduct(Long productId) {
        return achatsRepository.getTotalQuantityByProduct(productId);
    }
}
