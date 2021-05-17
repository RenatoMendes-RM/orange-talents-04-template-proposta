package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/propostas")
public class NovaPropostaController {


    @Autowired
    private PropostaRepository propostaRepository;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovaPropostaRequest request,
                                      UriComponentsBuilder uriBuilder) {

        if (propostaRepository.existsByDocumento(request.getDocumento())) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Proposta novaProposta = request.paraProposta();

        propostaRepository.save(novaProposta);

        //ServletUriComponentsBuilder - > alternativa com mesmo proposito que o utilizado abaixo:
        URI location = uriBuilder.path("/api/propostas/{id}")
                                 .buildAndExpand(novaProposta.getId())
                                 .toUri();

        return ResponseEntity.created(location).build();

    }
}
