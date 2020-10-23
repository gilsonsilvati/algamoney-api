package br.com.algamoney.api.domain.model;

import br.com.algamoney.api.domain.model.base.EntidadeBase;
import br.com.algamoney.api.domain.model.enums.TipoLancamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Lancamento extends EntidadeBase {

    private String descricao;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    private BigDecimal valor;
    private String observacao;

    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    @ManyToOne
    @JoinColumn(name = "codigo_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "codigo_pessoa")
    private Pessoa pessoa;

}
