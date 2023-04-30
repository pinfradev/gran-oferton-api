package com.gran.oferton.granoferton.modules.users.domain.service;

import com.gran.oferton.granoferton.modules.users.domain.dto.Administrator;
import com.gran.oferton.granoferton.modules.users.domain.dto.User;
import com.gran.oferton.granoferton.modules.users.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private UserRepository userRepository;
    public UsersService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }
    public List<Administrator>  getAdministrators() {
        return userRepository.getAllAdministrators();
    }

    public Administrator saveAdministrator(Administrator administrator) {
        return userRepository.saveAdministrator(administrator);
    }

    public Optional<Administrator> getUserByCredentials(String userName, String password) {
        return userRepository.getUserByCredentials(userName, password);
    }

    public void deleteAdminById(int id) {
        userRepository.deleteUserById(id);
    }

    public boolean isAdminPresent(int id) {
        return userRepository.isAdminPresent(id);
    }
}
