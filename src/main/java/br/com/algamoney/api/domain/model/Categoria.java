package br.com.algamoney.api.domain.model;

import br.com.algamoney.api.domain.model.base.EntidadeBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter
public class Categoria extends EntidadeBase {

    @NotBlank
    @Size(min = 3, max = 50)
    private String nome;

}
