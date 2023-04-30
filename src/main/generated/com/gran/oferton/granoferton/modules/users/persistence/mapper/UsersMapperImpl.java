package com.gran.oferton.granoferton.modules.users.persistence.mapper;

import com.gran.oferton.granoferton.modules.users.domain.dto.Administrator;
import com.gran.oferton.granoferton.modules.users.persistence.entity.AdministratorEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-30T08:12:49-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

    @Override
    public Administrator toAdministrator(AdministratorEntity administratorEntity) {
        if ( administratorEntity == null ) {
            return null;
        }

        Administrator administrator = new Administrator();

        if ( administratorEntity.getId() != null ) {
            administrator.setId( administratorEntity.getId() );
        }
        administrator.setName( administratorEntity.getName() );
        administrator.setLastName( administratorEntity.getLastName() );
        administrator.setRol( administratorEntity.getRol() );
        administrator.setUserName( administratorEntity.getUserName() );
        administrator.setPassword( administratorEntity.getPassword() );

        return administrator;
    }

    @Override
    public List<Administrator> toAdministrators(List<AdministratorEntity> administratorEntities) {
        if ( administratorEntities == null ) {
            return null;
        }

        List<Administrator> list = new ArrayList<Administrator>( administratorEntities.size() );
        for ( AdministratorEntity administratorEntity : administratorEntities ) {
            list.add( toAdministrator( administratorEntity ) );
        }

        return list;
    }

    @Override
    public AdministratorEntity toAdministratorEntity(Administrator administrator) {
        if ( administrator == null ) {
            return null;
        }

        AdministratorEntity administratorEntity = new AdministratorEntity();

        administratorEntity.setId( administrator.getId() );
        administratorEntity.setName( administrator.getName() );
        administratorEntity.setLastName( administrator.getLastName() );
        administratorEntity.setRol( administrator.getRol() );
        administratorEntity.setUserName( administrator.getUserName() );
        administratorEntity.setPassword( administrator.getPassword() );

        return administratorEntity;
    }
}
