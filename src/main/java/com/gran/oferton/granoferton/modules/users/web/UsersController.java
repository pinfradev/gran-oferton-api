package com.gran.oferton.granoferton.modules.users.web;

import com.gran.oferton.granoferton.modules.users.domain.dto.Administrator;
import com.gran.oferton.granoferton.modules.users.domain.dto.LoginRequest;
import com.gran.oferton.granoferton.modules.users.domain.dto.User;
import com.gran.oferton.granoferton.modules.users.domain.service.UsersService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users/")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(
            UsersService usersService
    ) {
        this.usersService = usersService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Administrator>> getAllUsers() {
        List<Administrator> users = usersService.getAdministrators();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Administrator> saveAdministrator(@RequestBody Administrator administrator) {
        Administrator admin =  usersService.saveAdministrator(administrator);
        return new ResponseEntity(admin, HttpStatus.CREATED);
    }

    @PostMapping(path="/login")
    public ResponseEntity<Administrator> getByCredentials(@RequestBody LoginRequest request) {
        Optional<Administrator> administrator = usersService.getUserByCredentials(
                request.getUserName(), request.getPassword());
        return administrator.map(
                admin -> new ResponseEntity<>(admin, HttpStatus.OK))
                .orElse(new ResponseEntity(Map.of(
                        "message", "Credenciales incorrectas"
                ), HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteAdminById(@PathVariable int id) {
        if (!usersService.isAdminPresent(id)) {
            return new ResponseEntity(Map.of(
                    "error", "admin not found"
            ), HttpStatus.NOT_FOUND);
        }

        usersService.deleteAdminById(id);
        return new ResponseEntity(Map.of(
                "message", "admin deleted successfully"
        ), HttpStatus.OK);
    }
}
