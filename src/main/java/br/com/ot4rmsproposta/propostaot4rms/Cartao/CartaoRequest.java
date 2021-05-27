package br.com.ot4rmsproposta.propostaot4rms.Cartao;

import br.com.ot4rmsproposta.propostaot4rms.novaProposta.Proposta;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

public class CartaoRequest {
    @NotNull
    @NotBlank
    private String id;

    private ZonedDateTime emitidoem;

    private String titular;

    private Integer limite;

    private Long idrenegociacao;

    private Long idvencimento;

    private Long idproposta;


    /* @Deprecated Somente para uso do framework hibernate */
    @Deprecated
    public CartaoRequest() {};

    public CartaoRequest(String id, Long idproposta) {
        this.id = id;
        this.idproposta = idproposta;
    }

    public CartaoRequest(ZonedDateTime emitidoem,
                         String titular,
                         Integer limite,
                         Long idrenegociacao,
                         Long idvencimento,
                         Long idproposta) {
        this.emitidoem = emitidoem;
        this.titular = titular;
        this.limite = limite;
        this.idrenegociacao = idrenegociacao;
        this.idvencimento = idvencimento;
        this.idproposta = idproposta;
    }

    public CartaoRequest(String id
            , ZonedDateTime emitidoem
            , String titular
            , Integer limite
            , Long idproposta) {
        this.id = id;
        this.emitidoem = emitidoem;
        this.titular = titular;
        this.limite = limite;
        this.idproposta = idproposta;
    }
}