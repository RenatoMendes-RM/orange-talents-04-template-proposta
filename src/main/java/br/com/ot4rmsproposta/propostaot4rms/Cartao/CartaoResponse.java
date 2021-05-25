package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import java.util.ArrayList;

public class AssociaCartaoPropostaResponse {

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

}
