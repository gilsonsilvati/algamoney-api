package br.com.algamoney.api.domain.repository;

import br.com.algamoney.api.domain.model.Lancamento;
import br.com.algamoney.api.domain.repository.lancamento.LancamentosQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Lancamentos extends JpaRepository<Lancamento, Long>, LancamentosQuery { }
