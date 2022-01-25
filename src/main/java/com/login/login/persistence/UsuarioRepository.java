package com.login.login.persistence;

import java.util.Optional;

import com.login.login.domain.User;
import com.login.login.domain.repository.UserRepository;
import com.login.login.persistence.crud.UsuarioCrudRepository;
import com.login.login.persistence.entity.Usuario;
import com.login.login.persistence.mapper.UsuarioMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UsuarioMapper mapper;

    @Override
    public Optional<User> findByUserName(String userName) {
        return usuarioCrudRepository.findByNombreUsuario(userName).map(usuarip -> mapper.toUser(usuarip));
    }

    @Override
    public void save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        usuarioCrudRepository.save(usuario);
    }

}