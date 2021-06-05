package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

public enum ResultadoSolicitacao {

    COM_RESTRICAO(StatusProposta.NAO_ELEGIVEL),
    SEM_RESTRICAO(StatusProposta.ELEGIVEL);

    private final StatusProposta statusProposta;

    ResultadoSolicitacao (StatusProposta statusProposta) {
        this.statusProposta = statusProposta;
    }

    public StatusProposta getStatusProposta() {
        return statusProposta;
    }
}
