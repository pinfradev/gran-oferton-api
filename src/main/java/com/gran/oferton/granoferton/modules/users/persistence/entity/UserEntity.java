package com.gran.oferton.granoferton.modules.users.persistence.entity;

import jakarta.persistence.*;
import org.springframework.lang.Nullable;

@MappedSuperclass
public class UserEntity {

    @Id
    @Column(name = "cedula")
    private Integer id;

    private String name;

    @Column(name = "last_name")
    @Nullable
    private String lastName;
    private String rol;

    @Column(name = "user_name")
    private String userName;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
