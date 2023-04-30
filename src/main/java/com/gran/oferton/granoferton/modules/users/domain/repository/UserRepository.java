package com.gran.oferton.granoferton.modules.users.domain.repository;

import com.gran.oferton.granoferton.modules.products.domain.dto.Product;
import com.gran.oferton.granoferton.modules.users.domain.dto.Administrator;
import com.gran.oferton.granoferton.modules.users.domain.dto.User;
import com.gran.oferton.granoferton.modules.users.persistence.entity.AdministratorEntity;
import com.gran.oferton.granoferton.modules.users.persistence.mapper.UsersMapper;
import com.gran.oferton.granoferton.modules.users.persistence.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private UserCrudRepository userCrudRepository;
    private UsersMapper usersMapper;

    @Autowired
    public UserRepository(
            UserCrudRepository userCrudRepository,
            UsersMapper usersMapper
    ) {
        this.userCrudRepository = userCrudRepository;
        this.usersMapper = usersMapper;
    }
    public List<Administrator> getAllAdministrators() {
        List<AdministratorEntity> entities = (List<AdministratorEntity>) userCrudRepository.findAll();
        return usersMapper.toAdministrators(entities);
    }

    public Administrator saveAdministrator(Administrator administrator) {
        AdministratorEntity administratorEntity = usersMapper.toAdministratorEntity(administrator);
        AdministratorEntity savedEntity =  userCrudRepository.save(administratorEntity);
        return usersMapper.toAdministrator(savedEntity);
    }

    public Optional<Administrator> getUserByCredentials(String userName, String password) {
        Optional<AdministratorEntity> entity = userCrudRepository.findByUserNameAndPassword(userName, password);
        if (entity.isPresent()) {
            Administrator admin = usersMapper.toAdministrator(entity.get());
            return Optional.of(admin);
        }

        return Optional.empty();
    }

    public void deleteUserById(int id) {
        userCrudRepository.deleteById(id);
    }

    public boolean isAdminPresent(int id) {
        return userCrudRepository.findById(id).isPresent();
    }
}
