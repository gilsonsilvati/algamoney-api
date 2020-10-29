package br.com.algamoney.api.domain.service;

import br.com.algamoney.api.domain.model.Lancamento;
import br.com.algamoney.api.domain.model.Pessoa;
import br.com.algamoney.api.domain.repository.Lancamentos;
import br.com.algamoney.api.domain.repository.Pessoas;
import br.com.algamoney.api.domain.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private Pessoas pessoas;

    @Autowired
    private Lancamentos lancamentos;

    public Lancamento salvar(Lancamento lancamento) {
        Optional<Pessoa> pessoaOptional = pessoas.findById(lancamento.getPessoa().getCodigo());

        if (pessoaOptional.isEmpty() || pessoaOptional.get().isInativo())
            throw new PessoaInexistenteOuInativaException();

        return lancamentos.save(lancamento);
    }

}
