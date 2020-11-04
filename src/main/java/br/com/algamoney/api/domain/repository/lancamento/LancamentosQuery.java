package br.com.algamoney.api.domain.repository.lancamento;

import br.com.algamoney.api.domain.model.Lancamento;
import br.com.algamoney.api.domain.repository.filter.LancamentoFilter;

import java.util.List;

public interface LancamentosQuery {

    List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);

}
