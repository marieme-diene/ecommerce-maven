package com.groupeisi.company.service;

import com.groupeisi.company.dto.ProduitsDto;
import com.groupeisi.company.entities.Produits;
import com.groupeisi.company.mapper.ProduitsMapper;
import com.groupeisi.company.dao.ProduitsRepository;
import com.groupeisi.company.dao.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProduitsService {
    
    private final ProduitsRepository produitsRepository;
    private final UsersRepository usersRepository;
    private final ProduitsMapper produitsMapper;
    
    public List<ProduitsDto> findAll() {
        log.info("Finding all products");
        List<Produits> produits = produitsRepository.findAll();
        return produitsMapper.toDtoList(produits);
    }
    
    public Optional<ProduitsDto> findById(Long id) {
        log.info("Finding product by id: {}", id);
        return produitsRepository.findById(id)
                .map(produitsMapper::toDto);
    }
    
    public Optional<ProduitsDto> findByRef(String ref) {
        log.info("Finding product by reference: {}", ref);
        return produitsRepository.findByRef(ref)
                .map(produitsMapper::toDto);
    }
    
    public List<ProduitsDto> findByUserId(Long userId) {
        log.info("Finding products by user id: {}", userId);
        List<Produits> produits = produitsRepository.findByUserId(userId);
        return produitsMapper.toDtoList(produits);
    }
    
    public List<ProduitsDto> findAvailableProducts() {
        log.info("Finding available products");
        List<Produits> produits = produitsRepository.findAvailableProducts();
        return produitsMapper.toDtoList(produits);
    }
    
    public ProduitsDto save(ProduitsDto produitsDto) {
        log.info("Saving product: {}", produitsDto.getRef());
        
        if (produitsRepository.existsByRef(produitsDto.getRef())) {
            throw new RuntimeException("Product with reference " + produitsDto.getRef() + " already exists");
        }
        
        Produits produits = produitsMapper.toEntity(produitsDto);
        
        if (produitsDto.getUserId() != null) {
            usersRepository.findById(produitsDto.getUserId())
                    .ifPresent(produits::setUser);
        }
        
        Produits savedProduits = produitsRepository.save(produits);
        return produitsMapper.toDto(savedProduits);
    }
    
    public ProduitsDto update(Long id, ProduitsDto produitsDto) {
        log.info("Updating product with id: {}", id);
        return produitsRepository.findById(id)
                .map(existingProduit -> {
                    existingProduit.setRef(produitsDto.getRef());
                    existingProduit.setName(produitsDto.getName());
                    existingProduit.setStock(produitsDto.getStock());
                    
                    if (produitsDto.getUserId() != null) {
                        usersRepository.findById(produitsDto.getUserId())
                                .ifPresent(existingProduit::setUser);
                    }
                    
                    Produits updatedProduit = produitsRepository.save(existingProduit);
                    return produitsMapper.toDto(updatedProduit);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
    
    public void deleteById(Long id) {
        log.info("Deleting product with id: {}", id);
        if (!produitsRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        produitsRepository.deleteById(id);
    }
    
    public boolean existsByRef(String ref) {
        return produitsRepository.existsByRef(ref);
    }
}
