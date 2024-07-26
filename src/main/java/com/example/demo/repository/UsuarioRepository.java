package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.infra.UsuarioEntity;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {

}
