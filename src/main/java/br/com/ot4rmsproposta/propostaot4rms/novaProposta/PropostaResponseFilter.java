package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PropostaResponseFilter {
    private Long id;
    private Andamento andamento;

    public PropostaResponseFilter(Proposta proposta) {
        this.id = proposta.getId();
        this.andamento = proposta.getAndamento();
    }
    public Long getId() {
        return id;
    }

    public Andamento getAndamento() {
        return andamento;
    }
}
