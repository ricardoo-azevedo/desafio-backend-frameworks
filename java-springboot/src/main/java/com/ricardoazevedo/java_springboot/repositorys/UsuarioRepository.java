package com.ricardoazevedo.java_springboot.repositorys;



import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ricardoazevedo.java_springboot.models.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

  
}

