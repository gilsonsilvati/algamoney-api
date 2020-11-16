package br.com.algamoney.api.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Permissao {

	@Id
	private Long codigo;
	private String descricao;

}
