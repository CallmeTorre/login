package com.login.login.persistence.mapper;

import com.login.login.domain.User;
import com.login.login.persistence.entity.Usuario;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombreUsuario", target = "userName"),
            @Mapping(source = "contrasena", target = "password"),
    })
    User toUser(Usuario usuario);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);
}
