package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "analise-solicitacao", url = "http://analise:9999")
public interface AnaliseSolicitacaoClient {

    @PostMapping("/api/solicitacao")
    PropostaResponse consultaPropostaElegivel(AnaliseDePropostaRequest request);
}