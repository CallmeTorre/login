package com.login.login.persistence.crud;

import java.util.Optional;

import com.login.login.persistence.entity.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
