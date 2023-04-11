package br.com.cadastruser.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "CU_USUARIO")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Min(0)
    private int idade;
    @NotBlank @JsonProperty(access = Access.WRITE_ONLY)
    private String cpf;
    private String numero;
    @NotBlank
    private String email;
    @NotNull @JsonProperty(access = Access.WRITE_ONLY)
    private String senha;
    
    public Usuario() {
    }
    
}
 