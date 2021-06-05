package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import br.com.ot4rmsproposta.propostaot4rms.Cartao.CartaoClientAPI;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/propostas")
public class PropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private AnaliseSolicitacaoClient analiseClient;

    @Autowired
    private CartaoClientAPI cartaoClientAPI;

    // Task 015.consultando_dados_solicitante
    // Alternativa para tornar nossa API " um client" 1: usar:
    // private RestTemplate

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovaPropostaRequest request,
                                      UriComponentsBuilder uriBuilder) {

        if (propostaRepository.existsByDocumento(request.getDocumento())) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Proposta novaProposta = request.paraProposta();

        propostaRepository.save(novaProposta);

        try {
            AnaliseDePropostaRequest analiseRequest = new AnaliseDePropostaRequest(
                    novaProposta.getDocumento(),
                    novaProposta.getNome(),
                    novaProposta.getId().toString());

            PropostaResponse resultadoDaConsulta = analiseClient.consultaPropostaElegivel(analiseRequest);
            StatusProposta statusproposta = resultadoDaConsulta.getStatusProposta();
            novaProposta.setStatusProposta(statusproposta);
        } catch (FeignException.UnprocessableEntity unprocessableEntity) {
            novaProposta.setStatusProposta(StatusProposta.NAO_ELEGIVEL);
        }
        Andamento andamento = (novaProposta.getStatusProposta() == StatusProposta.NAO_ELEGIVEL) ?  Andamento.PROPOSTA_RECUSADA : Andamento.EM_ANALISE;
        novaProposta.setAndamento(andamento);

        propostaRepository.save(novaProposta);

        //ServletUriComponentsBuilder - > alternativa com mesmo proposito que o utilizado abaixo:
        URI location = uriBuilder.path("/api/propostas/{id}")
                                 .buildAndExpand(novaProposta.getId())
                                 .toUri();

        return ResponseEntity.created(location).build();
    }

    //035 acompanhamento proposta
    @GetMapping("/{id}")
    public ResponseEntity<PropostaResponseFilter> buscarPeloIdProposta(@PathVariable Long id) {
        Optional<Proposta> possivelProposta = propostaRepository.findById(id);
        return possivelProposta
                .map(proposta -> ResponseEntity.ok()
                        .body(new PropostaResponseFilter(proposta)))
                .orElse(ResponseEntity.notFound().build());
    }
}