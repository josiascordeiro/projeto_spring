package br.com.api.produto.modelo; // Declaração do pacote

import org.springframework.stereotype.Component; // Importa a anotação Component para definir a classe como um bean gerenciado pelo Spring

import lombok.Setter; // Importa a anotação Setter do Lombok para gerar métodos setters automaticamente
import lombok.Getter; // Importa a anotação Getter do Lombok para gerar métodos getters automaticamente

@Component // Anotação para indicar que esta classe é um componente gerenciado pelo Spring
@Getter // Anotação do Lombok para gerar métodos getters para todos os campos da classe
@Setter // Anotação do Lombok para gerar métodos setters para todos os campos da classe
public class RespostaModelo {
    // Classe vazia que será usada como modelo de resposta
    private String mensagem;
}