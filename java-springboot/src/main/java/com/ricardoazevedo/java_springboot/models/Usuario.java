package com.ricardoazevedo.java_springboot.models;


import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

  @Id
  @GeneratedValue
  @Column(columnDefinition = "BINARY(16)")
  private UUID id;

  @Column(nullable = false)
  private String nomeCompleto;

  @Column(nullable = false, unique = true)
  private String cpf;

  @Column(nullable = false)
  private int anoNasc;

  public Usuario(String nomeCompleto, String cpf, int anoNasc) {
    this.nomeCompleto = nomeCompleto;
    this.cpf = cpf;
    this.anoNasc = anoNasc;
  }

}