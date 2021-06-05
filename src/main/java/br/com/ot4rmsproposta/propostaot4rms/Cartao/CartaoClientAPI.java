package br.com.ot4rmsproposta.propostaot4rms.Cartao;

import br.com.ot4rmsproposta.propostaot4rms.Cartao.BloqueioCartao.BloqueioCartaoRequest;
import br.com.ot4rmsproposta.propostaot4rms.Cartao.CartaoResponse;
import br.com.ot4rmsproposta.propostaot4rms.novaProposta.AssociaCartaoPropostaRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "cartao", url = "${cartao.host}") // criar config para selecionar "contas" no Docker ou "localhost" no computador local.
@Component
public interface CartaoClientAPI {

    @GetMapping("/api/cartoes")
    CartaoResponse consulta(AssociaCartaoPropostaRequest request);

}