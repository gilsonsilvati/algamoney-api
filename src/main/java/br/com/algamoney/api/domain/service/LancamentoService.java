package br.com.algamoney.api.domain.service;

import br.com.algamoney.api.domain.model.Lancamento;
import br.com.algamoney.api.domain.model.Pessoa;
import br.com.algamoney.api.domain.repository.Lancamentos;
import br.com.algamoney.api.domain.repository.Pessoas;
import br.com.algamoney.api.domain.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.BeanUtils;
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
        validarPessoa(lancamento.getCodigo());

        return lancamentos.save(lancamento);
    }

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        Lancamento lancamentoSalvo = buscarLancamentoExistente(codigo);

        if (!lancamento.getPessoa().equals(lancamentoSalvo.getPessoa())) {
            validarPessoa(lancamento.getCodigo());
        }

        BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");

        return lancamentos.save(lancamentoSalvo);
    }

    private void validarPessoa(Long codigo) {
        Optional<Pessoa> pessoaOptional = pessoas.findById(codigo);

        if (pessoaOptional.isEmpty() || pessoaOptional.get().isInativo())
            throw new PessoaInexistenteOuInativaException();
    }

    private Lancamento buscarLancamentoExistente(Long codigo) {
        Lancamento lancamentoSalvo = lancamentos.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException());

        return lancamentoSalvo;
    }

}
