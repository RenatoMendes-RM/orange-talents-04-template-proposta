package br.com.ot4rmsproposta.propostaot4rms.Cartao.BloqueioCartao;

import javax.validation.constraints.NotBlank;

public class BloqueioCartaoRequest {
    @NotBlank
    private String sistemaResponsavel = "propostas";

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }
}
