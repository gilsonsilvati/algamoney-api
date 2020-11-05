package br.com.algamoney.api.domain.repository.lancamento;

import br.com.algamoney.api.domain.model.Lancamento;
import br.com.algamoney.api.domain.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentosQuery {

    Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);

}
