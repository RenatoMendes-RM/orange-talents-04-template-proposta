package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/propostas")
public class NovaPropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private AnaliseSolicitacaoClient analiseClient;

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
                    novaProposta.getId());
            AnaliseDePropostaResponse resultadoDaConsulta = analiseClient.consulta(analiseRequest);
            Status status = resultadoDaConsulta.status();
            novaProposta.setStatus(status);
        } catch (FeignException.UnprocessableEntity unprocessableEntity) {
            novaProposta.setStatus(Status.NAO_ELEGIVEL);
        }

        propostaRepository.save(novaProposta);

        //ServletUriComponentsBuilder - > alternativa com mesmo proposito que o utilizado abaixo:
        URI location = uriBuilder.path("/api/propostas/{id}")
                                 .buildAndExpand(novaProposta.getId())
                                 .toUri();

        return ResponseEntity.created(location).build();

    }
}
