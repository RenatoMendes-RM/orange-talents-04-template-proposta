package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

public class AssociaCartaoPropostaRequest {

    private Long idProposta;

    /* @Deprecated Somente para uso do framework hibernate */
    @Deprecated
    public AssociaCartaoPropostaRequest() { }

    public AssociaCartaoPropostaRequest(Long idProposta) {
        this.idProposta = idProposta;
    }

    public Long getIdProposta() {
        return idProposta;
    }

    public Proposta paraCartaoProposta() {
        return new Proposta();
    }
}