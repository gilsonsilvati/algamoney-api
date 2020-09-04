package br.com.algamoney.api.resource;

import br.com.algamoney.api.domain.model.Categoria;
import br.com.algamoney.api.domain.repository.Categorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private Categorias categorias;

    @GetMapping
    public List<Categoria> listar() {
        return categorias.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

}
