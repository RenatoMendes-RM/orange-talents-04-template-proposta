package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "associa-cartao", url = "http://localhost:8888")
public interface AssociaCartaoPropostaClient {

    @GetMapping("/api/cartoes")
    AssociaCartaoPropostaResponse consulta(AssociaCartaoPropostaRequest request);
}