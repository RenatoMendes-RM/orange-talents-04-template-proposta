package br.com.ot4rmsproposta.propostaot4rms.Cartao;

import br.com.ot4rmsproposta.propostaot4rms.Cartao.BloqueioCartao.BloqueioCartao;
import br.com.ot4rmsproposta.propostaot4rms.novaProposta.Proposta;
import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "cartao")
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

    @Enumerated(value = EnumType.STRING)
    private StatusCartao statuscartao = StatusCartao.ATIVO;

    @OneToOne(cascade = CascadeType.MERGE) @JoinColumn(name = "bloqueiocartao")
    private BloqueioCartao bloqueioCartao;

    public Cartao(){

    }

    public Cartao(String id, ZonedDateTime emitidoem, String titular, Integer limite, Proposta proposta) {
        this.id = id;
        this.emitidoem = emitidoem;
        this.titular = titular;
        this.limite = limite;
        this.proposta = proposta;
    }

    public boolean isBlocked() {
       return this.statuscartao.equals(StatusCartao.BLOQUEADO);
    }

    public String getId() {
        return id;
    }

    public void setBloqueioCartao(BloqueioCartao bloqueioCartao) {
        this.bloqueioCartao = bloqueioCartao;
        this.statuscartao = StatusCartao.BLOQUEADO;
    }
}
