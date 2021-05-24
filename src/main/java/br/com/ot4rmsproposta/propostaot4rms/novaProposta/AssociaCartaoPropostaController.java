package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;




@RestController
@RequestMapping("/api/propostas")
public class AssociaCartaoPropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private AssociaCartaoPropostaClient associaCartaoPropostaClient;



}
