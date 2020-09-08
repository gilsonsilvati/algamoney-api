package br.com.algamoney.api.domain.repository;

import br.com.algamoney.api.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pessoas extends JpaRepository<Pessoa, Long> { }
