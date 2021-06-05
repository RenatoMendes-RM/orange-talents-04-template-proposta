package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private BigDecimal salario;

    @NotBlank
    @Documento
    private String documento;

    @NotNull
    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private StatusProposta statusproposta;

    private String numerocartao;

    @Enumerated(EnumType.STRING)
    //@NotNull
    private Andamento andamento;

    /*
    * @Deprecated  apenas para uso do hibernete.
    * */
    @Deprecated
    private Proposta(@Email @NotBlank String email
            , @NotBlank String nome
            , @NotNull @Positive BigDecimal salario
            , @NotBlank String documento
            , Endereco novoEndereco
            , String numerocartao) { }

    public Proposta(String email,
                    String nome,
                    BigDecimal salario,
                    String documento,
                    Endereco endereco,
                    Andamento andamento) {
        this.email = email;
        this.nome = nome;
        this.salario = salario;
        this.documento = documento;
        this.endereco = endereco;
        this.andamento = andamento;
    }

    public Proposta() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNumerocartao() {
        return numerocartao;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public StatusProposta getStatusProposta() {
        return statusproposta;
    }

    public Andamento getAndamento() {
        return andamento;
    }

    public void setStatusProposta(StatusProposta statusproposta) {
        this.statusproposta = statusproposta;
    }

    public void setNumerocartao(String numerocartao) {
        this.numerocartao = numerocartao;
    }

    public void setAndamento(Andamento andamento) {
        this.andamento = andamento;
    }
}
