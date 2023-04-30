package com.gran.oferton.granoferton.modules.users.persistence.repository;

import com.gran.oferton.granoferton.modules.users.persistence.entity.AdministratorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<AdministratorEntity, Integer> {
    Optional<AdministratorEntity> findByUserNameAndPassword(String userName, String password);
}
