package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

public class PropostaResponse {
    private String documento;
    private String nome;
    private String idProposta;
    private ResultadoSolicitacao resultadoSolicitacao;
    public String getDocumento() {
        return documento;
    }
    public String getNome() {
        return nome;
    }
    public String getIdProposta() {
        return idProposta;
    }
    public ResultadoSolicitacao getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }
    public StatusProposta getStatusProposta() {
        return resultadoSolicitacao.getStatusProposta();
    }
}