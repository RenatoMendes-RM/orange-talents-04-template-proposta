package br.com.ot4rmsproposta.propostaot4rms.Cartao;

import br.com.ot4rmsproposta.propostaot4rms.novaProposta.Proposta;
import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Cartao {
    @Id
    private String id;

    private ZonedDateTime emitidoem;

    private String titular;

    private Integer limite;

    private Long idrenegociacao;

    private Long idvencimento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproposta")
    private Proposta proposta;

    public Cartao(){

    }

    public Cartao(String id, ZonedDateTime emitidoem, String titular, Integer limite, Proposta proposta) {
        this.id = id;
        this.emitidoem = emitidoem;
        this.titular = titular;
        this.limite = limite;
        this.proposta = proposta;
    }
}
