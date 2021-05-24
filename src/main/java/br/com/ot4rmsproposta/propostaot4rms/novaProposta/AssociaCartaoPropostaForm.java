package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AssociaCartaoPropostaForm {

    @NotBlank
    @NotNull
    private Long id;

    @NotBlank
    @NotNull
    private String numerocartao;

    public AssociaCartaoPropostaForm(Long id, String numerocartao) {
        this.id = id;
        this.numerocartao = numerocartao;
    }


    public static Proposta atualizar(Long id, String numerocartao, PropostaRepository propostaRepository) {
        Proposta proposta = propostaRepository.findById(id).get();
        proposta.setNumerocartao(numerocartao);
        return proposta;
    }
}
