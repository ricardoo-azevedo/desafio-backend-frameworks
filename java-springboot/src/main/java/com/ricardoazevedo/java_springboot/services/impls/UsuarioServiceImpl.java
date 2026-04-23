package com.ricardoazevedo.java_springboot.services.impls;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardoazevedo.java_springboot.dtos.UsuarioDto;
import com.ricardoazevedo.java_springboot.models.Usuario;
import com.ricardoazevedo.java_springboot.repositorys.UsuarioRepository;
import com.ricardoazevedo.java_springboot.services.interfaces.UsuarioServiceInterface;






@Service
public class UsuarioServiceImpl implements UsuarioServiceInterface {

  @Autowired
  UsuarioRepository usuarioRepository;

  private UsuarioDto toDto(Usuario u) {
    return new UsuarioDto(
        u.getId(),
        u.getNomeCompleto(),
        u.getCpf(),
        u.getAnoNasc());
  }

  private Usuario toModel(UsuarioDto u) {
    return new Usuario(
        u.getNomeCompleto(),
        u.getCpf(),
        u.getAnoNasc());
  }

  @Override
  public UsuarioDto salvar(UsuarioDto user) {
    Usuario salvo = usuarioRepository.save(toModel(user));
    return toDto(salvo);

  }

  @Override
  public List<UsuarioDto> listar() {
    return usuarioRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());

  }

}