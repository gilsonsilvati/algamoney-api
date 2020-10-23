package br.com.algamoney.api.domain.model;

import br.com.algamoney.api.domain.model.base.EntidadeBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
public class Pessoa extends EntidadeBase {

    @NotBlank
    private String nome;

    @NotNull
    private Boolean ativo;

    @Embedded
    private Endereco endereco;

}
