package br.com.ot4rmsproposta.propostaot4rms.Cartao;

import java.util.ArrayList;

public class CartaoResponse {

    private String id;
    private String emitidoEm;
    private String titular;

    private ArrayList bloqueios;
    private ArrayList avisos;
    private ArrayList carteiras;
    private ArrayList parcelas;
    private Integer limite;
    private ArrayList renegociacao;
    private ArrayList vencimento;
    private String idProposta;

    public String getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public String getEmitidoEm() {
        return emitidoEm;
    }

    public Integer getLimite() {
        return limite;
    }
}

