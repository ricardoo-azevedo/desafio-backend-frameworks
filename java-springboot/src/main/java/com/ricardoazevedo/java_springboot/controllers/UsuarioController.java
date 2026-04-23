package com.ricardoazevedo.java_springboot.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardoazevedo.java_springboot.dtos.UsuarioDto;
import com.ricardoazevedo.java_springboot.services.impls.UsuarioServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

  @Autowired
  UsuarioServiceImpl usuarioServiceImpl;

  @PostMapping
  public ResponseEntity<?> registrarUsuario(@Valid UsuarioDto u, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
    }
    UsuarioDto salvo = usuarioServiceImpl.salvar(u);
    return ResponseEntity.status(HttpStatus.CREATED).body(salvo);

  }

  @GetMapping
  public ResponseEntity<java.util.List<?>> listarUsuarios() {
    java.util.List<UsuarioDto> listarUsuarios = usuarioServiceImpl.listar();
    return ResponseEntity.ok().body(listarUsuarios);

  }

}