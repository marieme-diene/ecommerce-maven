package com.groupeisi.company.service;

import com.groupeisi.company.dto.VentesDto;
import com.groupeisi.company.entities.Ventes;
import com.groupeisi.company.mapper.VentesMapper;
import com.groupeisi.company.dao.VentesRepository;
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
public class VentesService {
    
    private final VentesRepository ventesRepository;
    private final ProduitsRepository produitsRepository;
    private final UsersRepository usersRepository;
    private final VentesMapper ventesMapper;
    
    public List<VentesDto> findAll() {
        log.info("Finding all sales");
        List<Ventes> ventes = ventesRepository.findAll();
        return ventesMapper.toDtoList(ventes);
    }
    
    public Optional<VentesDto> findById(Long id) {
        log.info("Finding sale by id: {}", id);
        return ventesRepository.findById(id)
                .map(ventesMapper::toDto);
    }
    
    public List<VentesDto> findByUserId(Long userId) {
        log.info("Finding sales by user id: {}", userId);
        List<Ventes> ventes = ventesRepository.findByUserId(userId);
        return ventesMapper.toDtoList(ventes);
    }
    
    public List<VentesDto> findByProductId(Long productId) {
        log.info("Finding sales by product id: {}", productId);
        List<Ventes> ventes = ventesRepository.findByProductId(productId);
        return ventesMapper.toDtoList(ventes);
    }
    
    public List<VentesDto> findByDateBetween(Date startDate, Date endDate) {
        log.info("Finding sales between {} and {}", startDate, endDate);
        List<Ventes> ventes = ventesRepository.findByDateBetween(startDate, endDate);
        return ventesMapper.toDtoList(ventes);
    }
    
    @Transactional
    public VentesDto save(VentesDto ventesDto) {
        log.info("Saving sale for product: {}", ventesDto.getProductId());
        
        Ventes ventes = ventesMapper.toEntity(ventesDto);
        
        if (ventesDto.getProductId() != null) {
            produitsRepository.findById(ventesDto.getProductId())
                    .ifPresent(ventes::setProduct);
        }
        
        if (ventesDto.getUserId() != null) {
            usersRepository.findById(ventesDto.getUserId())
                    .ifPresent(ventes::setUser);
        }
        
        if (ventes.getDateP() == null) {
            ventes.setDateP(new Date());
        }
        
        Ventes savedVentes = ventesRepository.save(ventes);
        return ventesMapper.toDto(savedVentes);
    }
    
    @Transactional
    public VentesDto update(Long id, VentesDto ventesDto) {
        log.info("Updating sale with id: {}", id);
        return ventesRepository.findById(id)
                .map(existingVente -> {
                    existingVente.setDateP(ventesDto.getDateP());
                    existingVente.setQuantity(ventesDto.getQuantity());
                    
                    if (ventesDto.getProductId() != null) {
                        produitsRepository.findById(ventesDto.getProductId())
                                .ifPresent(existingVente::setProduct);
                    }
                    
                    if (ventesDto.getUserId() != null) {
                        usersRepository.findById(ventesDto.getUserId())
                                .ifPresent(existingVente::setUser);
                    }
                    
                    Ventes updatedVente = ventesRepository.save(existingVente);
                    return ventesMapper.toDto(updatedVente);
                })
                .orElseThrow(() -> new RuntimeException("Sale not found with id: " + id));
    }
    
    public void deleteById(Long id) {
        log.info("Deleting sale with id: {}", id);
        if (!ventesRepository.existsById(id)) {
            throw new RuntimeException("Sale not found with id: " + id);
        }
        ventesRepository.deleteById(id);
    }
    
    public Double getTotalQuantityByProduct(Long productId) {
        return ventesRepository.getTotalQuantityByProduct(productId);
    }
}
