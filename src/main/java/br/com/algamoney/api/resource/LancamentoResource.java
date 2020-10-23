package br.com.algamoney.api.resource;

import br.com.algamoney.api.domain.model.Lancamento;
import br.com.algamoney.api.domain.repository.Lancamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

    @Autowired
    private Lancamentos lancamentos;

    @GetMapping
    public List<Lancamento> listar() {
        return lancamentos.findAll();
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Lancamento> buscarPorId(@PathVariable Long codigo) {
        return lancamentos.findById(codigo)
                .map(lancamento -> ResponseEntity.ok(lancamento))
                .orElse(ResponseEntity.notFound().build());
    }

}
