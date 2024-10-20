package br.com.api.produto.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produto.modelo.ProdutoModelo;

//marca a interfaca como um repositorio spring
@Repository
public interface ProdutoRepostiorio extends CrudRepository<ProdutoModelo, Long>{
            
}
