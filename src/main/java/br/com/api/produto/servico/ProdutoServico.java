package br.com.api.produto.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.api.produto.modelo.ProdutoModelo;
import br.com.api.produto.modelo.RespostaModelo;
import br.com.api.produto.repositorio.ProdutoRepostiorio;

@Service  //Anotação para injetar automaticamente a dependência do repositório de produtos
public class ProdutoServico {
            @Autowired
            private ProdutoRepostiorio pr;// Declaração do repositório de produtos
                
           @Autowired
           private RespostaModelo rm;//serve para validar as informações
            
            // Método para listar todos os produtos
            public Iterable <ProdutoModelo> Listar(){
                        return pr.findAll();
            }
            // Método para Cadastrar um produto específico
            public ResponseEntity<?> cadastrar(ProdutoModelo pm) {

                if(pm.getNome().equals("")){
                    rm.setMensagem("O nome do produto não pode ser vazio");
                    return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
                }else if(pm.getMarca().equals("")){
                    rm.setMensagem("A marca do produto não pode ser vazia");
                    return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
                }else{
                   return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
                }
            }
            
            public ResponseEntity<?> alterar(ProdutoModelo pm) {

                if(pm.getNome().equals("")){
                    rm.setMensagem("O nome do produto não pode ser vazio");
                    return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
                }else if(pm.getMarca().equals("")){
                    rm.setMensagem("A marca do produto não pode ser vazia");
                    return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
                }else{
                   return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
                }
            }

            public ResponseEntity<RespostaModelo> remover(long codigo){
                
                pr.deleteById(codigo);

                rm.setMensagem("Produto excluído com sucesso!");
                
                return  new ResponseEntity<RespostaModelo>(rm,HttpStatus.OK);
            }                   
}
