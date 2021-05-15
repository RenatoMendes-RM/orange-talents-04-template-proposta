package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import java.math.BigDecimal;

public class NovaPropostaRequest {

    private String email;
    private String nome;
    private BigDecimal salario;
    private String documento;
    private EnderecoRequest endereco;

    public NovaPropostaRequest(String email,
                               String nome,
                               BigDecimal salario,
                               String documento,
                               EnderecoRequest endereco) {
        this.email = email;
        this.nome = nome;
        this.salario = salario;
        this.documento = documento;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "NovaPropostaRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", salario=" + salario +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
