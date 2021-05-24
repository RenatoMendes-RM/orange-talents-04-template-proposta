package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@Component
public class AssociaCartaoProposta {

    @Autowired
    private AssociaCartaoPropostaClient associaCartaoPropostaClient;

    @Autowired
    private  PropostaRepository propostaRepository;

    @Scheduled(fixedDelay = 20000) // tempo em milesegundos.
    private void associarCartaoProposta(){

        // vou substituir linhas abaixo por:
        //     uma pesquisa que retornará Lista de Propostas marcadas com ELEGIVEL mas com numerocartao vazio.
        //     Depois farei um forEach na lista para rodar o try...
        Long idProposta;
        idProposta = 1L;
        String numerocartao;
        // Optional<Proposta> propostasElegiveisSemCartao = propostaRepository.findByNumerocartaos(null);




        try {
            AssociaCartaoPropostaRequest associaCartaoPropostaRequest = new AssociaCartaoPropostaRequest(idProposta);
            AssociaCartaoPropostaResponse associaCartaoPropostaResponse = associaCartaoPropostaClient.consulta(associaCartaoPropostaRequest);
            numerocartao = associaCartaoPropostaResponse.getId();
            Proposta propostaComCartao = AssociaCartaoPropostaForm.atualizar(idProposta, numerocartao, propostaRepository );
            propostaRepository.save(propostaComCartao);
        } catch (FeignException.UnprocessableEntity unprocessableEntity) {
        }
    }
}