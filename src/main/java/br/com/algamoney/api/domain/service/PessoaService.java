package br.com.algamoney.api.domain.service;

import br.com.algamoney.api.domain.model.Pessoa;
import br.com.algamoney.api.domain.repository.Pessoas;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private Pessoas pessoas;

    public Pessoa atualizar(Long codigo, Pessoa pessoa) {
        Pessoa pessoaSalva = buscarPessoaPorCodigo(codigo);

        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
        pessoas.save(pessoaSalva);

        return pessoaSalva;
    }

    public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
        Pessoa pessoaSalva = buscarPessoaPorCodigo(codigo);
        pessoaSalva.setAtivo(ativo);

        pessoas.save(pessoaSalva);
    }

    private Pessoa buscarPessoaPorCodigo(Long codigo) {
        return pessoas.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

}
