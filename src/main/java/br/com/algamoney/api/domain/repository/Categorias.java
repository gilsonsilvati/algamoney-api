package br.com.algamoney.api.domain.repository;

import br.com.algamoney.api.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Categorias extends JpaRepository<Categoria, Long> { }
