package br.com.algamoney.api.resource;

import br.com.algamoney.api.domain.model.Categoria;
import br.com.algamoney.api.domain.model.Pessoa;
import br.com.algamoney.api.domain.repository.Pessoas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private Pessoas pessoas;

    @GetMapping
    public List<Pessoa> listar() {
        return pessoas.findAll();
    }

    @PostMapping
    public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = pessoas.save(pessoa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{codigo}")
                .buildAndExpand(pessoaSalva.getCodigo())
                .toUri();

        return ResponseEntity.created(uri).body(pessoaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pessoa> buscarPorCodigo(@PathVariable Long codigo) {
        return pessoas.findById(codigo)
                .map(pessoa -> ResponseEntity.ok(pessoa))
                .orElse(ResponseEntity.notFound().build());
    }

}
