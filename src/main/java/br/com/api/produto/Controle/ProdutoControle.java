package br.com.api.produto.Controle; // Declaração do pacote

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Importa a anotação GetMapping para mapear requisições HTTP GET
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping; // Importa a anotação RestController para definir a classe como um controlador REST
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produto.modelo.ProdutoModelo;
import br.com.api.produto.modelo.RespostaModelo;
import br.com.api.produto.servico.ProdutoServico;

@RestController // Anotação para indicar que esta classe é um controlador REST

// Permite requisições de origens específicas (CORS)
@CrossOrigin(origins = "http://localhost:5173")

public class ProdutoControle {
            @Autowired 
            private ProdutoServico ps; // Declaração do serviço de produtos        

            //rota para deletar
            @DeleteMapping("/remover/{codigo}")
            public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo){
                return ps.remover(codigo);
            }

            //rota para cadastrar
            @PostMapping("/cadastrar")// Mapeia requisições HTTP POST para a URL "/cadastrar"
            public  ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm) {
             return ps.cadastrar(pm);
            }

            @PutMapping("/alterar")
            public  ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm) {
             return ps.alterar(pm);
            }

            public String postMethodName(@RequestBody String entity) {
                //TODO: process POST request
                
                return entity;
            }
            

            @GetMapping("/listar")
            public Iterable <ProdutoModelo>Listar(){
                return ps.Listar();
            }         

    @GetMapping("/") // Mapeia requisições HTTP GET para a URL raiz ("/")
    public String rota() {
        return "API de produtos funcionando"; // Retorna uma mensagem indicando que a API está funcionando
    }
}