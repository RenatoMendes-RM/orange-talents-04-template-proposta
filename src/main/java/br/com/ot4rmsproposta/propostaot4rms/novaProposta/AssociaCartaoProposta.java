package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import br.com.ot4rmsproposta.propostaot4rms.Cartao.Cartao;
import br.com.ot4rmsproposta.propostaot4rms.Cartao.CartaoRepository;
import br.com.ot4rmsproposta.propostaot4rms.Cartao.CartaoRequest;
import br.com.ot4rmsproposta.propostaot4rms.Cartao.CartaoResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;

@RestController
@Component
public class AssociaCartaoProposta {

    @Autowired
    private AssociaCartaoPropostaClient associaCartaoPropostaClient;

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Scheduled(fixedDelay = 20000) // tempo em milesegundos.
    private void associarCartaoProposta(){
        List<Proposta> propostasElegiveisSemCartao = propostaRepository.LocalizarElegiveisSemCartao();
        for (int i = 0; i < propostasElegiveisSemCartao.size(); i++) {
            Long idProposta = propostasElegiveisSemCartao.get(i).getId();
            String titular = propostasElegiveisSemCartao.get(i).getNome();
            if (!AssociaCartaoNaProposta(idProposta, titular)) {
                return;
            }
        }
    }

    private boolean AssociaCartaoNaProposta(Long idProposta, String titular) {
        try {
            AssociaCartaoPropostaRequest associaCartaoPropostaRequest = new AssociaCartaoPropostaRequest(idProposta);
            CartaoResponse cartaoResponse = associaCartaoPropostaClient.consulta(associaCartaoPropostaRequest);
                String numerocartao = cartaoResponse.getId();
                Proposta propostaComCartao = AssociaCartaoPropostaForm.atualizar(idProposta, numerocartao, Andamento.CARTAO_GERADO, propostaRepository);

                ZonedDateTime emitidoEm = ZonedDateTime.parse(cartaoResponse.getEmitidoEm().substring(0,10) +" "+
                                        cartaoResponse.getEmitidoEm().substring(11,19)
                        , DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC")));

                CartaoRequest cartaoRequest = new CartaoRequest (numerocartao, emitidoEm, cartaoResponse.getTitular(), cartaoResponse.getLimite(), idProposta);
                Cartao cartao = new Cartao (numerocartao, emitidoEm, titular, cartaoResponse.getLimite(), propostaComCartao);
                propostaRepository.save(propostaComCartao);
                cartaoRepository.save(cartao);
        } catch (FeignException.UnprocessableEntity unprocessableEntity) {
            return false;
        }
        return true;
    }
}