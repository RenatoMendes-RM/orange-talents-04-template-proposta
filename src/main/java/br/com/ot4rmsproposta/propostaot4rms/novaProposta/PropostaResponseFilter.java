package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PropostaResponse {

    private Long id;
    private String documento;
    private String email;
    private String nome;
    private Endereco endereco;
    private BigDecimal salario;
    private Status status;
    private String numerocartao;

    public PropostaResponse(@NotNull @Valid Proposta proposta) {
        this.id = proposta.getId();
        this.documento = proposta.getDocumento();
        this.email = proposta.getEmail();
        this.nome = proposta.getNome();
        this.endereco = proposta.getEndereco();
        this.salario = proposta.getSalario();
        this.status = proposta.getStatus();
        this.numerocartao = proposta.getNumerocartao();
    }

    public PropostaResponse(Long id, String nome, Status status) {
        Proposta proposta = new Proposta();
        this.id = proposta.getId();
        this.nome = proposta.getNome();
        this.status = proposta.getStatus();
    }


    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Status getStatus() {
        return status;
    }

    public String getNumerocartao() {
        return numerocartao;
    }
}
