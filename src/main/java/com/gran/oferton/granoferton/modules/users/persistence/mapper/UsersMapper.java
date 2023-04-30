package com.gran.oferton.granoferton.modules.users.persistence.mapper;

import com.gran.oferton.granoferton.modules.users.domain.dto.Administrator;
import com.gran.oferton.granoferton.modules.users.persistence.entity.AdministratorEntity;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    public Administrator toAdministrator(AdministratorEntity administratorEntity);

    public List<Administrator> toAdministrators(List<AdministratorEntity> administratorEntities);

    public AdministratorEntity toAdministratorEntity(Administrator administrator);
}
