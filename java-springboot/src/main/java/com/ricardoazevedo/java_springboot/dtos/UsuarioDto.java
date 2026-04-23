package com.ricardoazevedo.java_springboot.dtos;



import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private UUID id;

  @NotNull(message = "nome não pode ser nulo")
  private String nomeCompleto;

  @NotNull(message = "cpf não pode ser nulo")
  @Size(min = 14, max = 14, message = "cpf precisa ter 14 digitos")
  private String cpf;

  @NotNull(message = "ano de nascimento não pode ser nulo")
  private int anoNasc;

}
