package br.com.algamoney.api.domain.model;

import br.com.algamoney.api.domain.model.base.EntidadeBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
@Getter @Setter
public class Categoria extends EntidadeBase {

    private String nome;

}
