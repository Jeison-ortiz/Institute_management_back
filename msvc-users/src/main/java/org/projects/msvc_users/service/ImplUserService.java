package org.projects.msvc_users.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.projects.msvc_users.entity.UserEntity;
import org.projects.msvc_users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplUserService implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional;
        }
       return Optional.empty(); 
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
       return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(Long id ,UserEntity userEntity) {
        Optional<UserEntity> userUpdate = userRepository.findById(id);
        if (userUpdate.isPresent()) {
            UserEntity userEntity2 = userUpdate.get();

            if (userEntity.getName() != null) userEntity2.setName(userEntity.getName());
            if (userEntity.getAddress() != null) userEntity2.setAddress(userEntity.getAddress());
            if (userEntity.getEmail() != null) userEntity2.setEmail(userEntity.getEmail());
            if (userEntity.getPhone() != null) userEntity2.setPhone(userEntity.getPhone());
            if (userEntity.getPassword() != null) userEntity2.setPassword(userEntity.getPassword());
            if (userEntity.getDocument() != null) userEntity2.setDocument(userEntity.getDocument());
            if (userEntity.getDocumentType() != null) userEntity2.setDocumentType(userEntity.getDocumentType());
            if (userEntity.getBirthDate() != null) userEntity2.setBirthDate(userEntity.getBirthDate());
            if (userEntity.getCreatedAt() != null) userEntity2.setCreatedAt(userEntity.getCreatedAt());
            if (userEntity.getStatusUpdatedAt() != null) userEntity2.setStatusUpdatedAt(userEntity.getStatusUpdatedAt());
            if (userEntity.getDataUpdatedAt() != null) userEntity2.setDataUpdatedAt(userEntity.getDataUpdatedAt());
            else userEntity2.setDataUpdatedAt(new Date()); // Actualiza con fecha actual si no viene en el request
    
            if (userEntity.getTutorId() != null) userEntity2.setTutorId(userEntity.getTutorId());
            if (userEntity.getTutor() != null) userEntity2.setTutor(userEntity.getTutor());
    
            if (userEntity.getAgreementId() != null) userEntity2.setAgreementId(userEntity.getAgreementId());
            if (userEntity.getAgreement() != null) userEntity2.setAgreement(userEntity.getAgreement());
    
            // Para boolean, si quieres actualizar explícitamente, podrías hacer algo como esto:
            userEntity2.setStatus(userEntity.isStatus()); // Si `false` es válido, entonces sí lo actualizas directamente
    
            return userRepository.save(userEntity2);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

}
