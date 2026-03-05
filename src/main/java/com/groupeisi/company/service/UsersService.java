package com.groupeisi.company.service;

import com.groupeisi.company.dto.UsersDto;
import com.groupeisi.company.entities.Users;
import com.groupeisi.company.mapper.UsersMapper;
import com.groupeisi.company.dao.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersService {
    
    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;
    
    public List<UsersDto> findAll() {
        log.info("Finding all users");
        List<Users> users = usersRepository.findAll();
        return usersMapper.toDtoList(users);
    }
    
    public Optional<UsersDto> findById(Long id) {
        log.info("Finding user by id: {}", id);
        return usersRepository.findById(id)
                .map(usersMapper::toDto);
    }
    
    public Optional<UsersDto> findByEmail(String email) {
        log.info("Finding user by email: {}", email);
        return usersRepository.findByEmail(email)
                .map(usersMapper::toDto);
    }
    
    public UsersDto save(UsersDto usersDto) {
        log.info("Saving user: {}", usersDto.getEmail());
        Users users = usersMapper.toEntity(usersDto);
        Users savedUsers = usersRepository.save(users);
        return usersMapper.toDto(savedUsers);
    }
    
    public UsersDto update(Long id, UsersDto usersDto) {
        log.info("Updating user with id: {}", id);
        return usersRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setEmail(usersDto.getEmail());
                    existingUser.setPassword(usersDto.getPassword());
                    Users updatedUser = usersRepository.save(existingUser);
                    return usersMapper.toDto(updatedUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    
    public void deleteById(Long id) {
        log.info("Deleting user with id: {}", id);
        if (!usersRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        usersRepository.deleteById(id);
    }
    
    public boolean existsByEmail(String email) {
        return usersRepository.existsByEmail(email);
    }
}
