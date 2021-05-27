package br.com.ot4rmsproposta.propostaot4rms.Cartao;

import br.com.ot4rmsproposta.propostaot4rms.novaProposta.*;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;




@RestController
@RequestMapping("/api/Cartoes")
public class AssociaCartaoPropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private AssociaCartaoPropostaClient associaCartaoPropostaClient;

  /*  @PutMapping("/{id}")
    public ResponseEntity<?> associaNovoCartao(@PathVariable Long id) {
        // ,
        //                                               @RequestBody @Valid AssociaCartaoPropostaRequest request

        AssociaCartaoPropostaRequest request = new AssociaCartaoPropostaRequest();


        Proposta propostaParaAtualizarCartao = request.paraCartaoProposta();
        propostaParaAtualizarCartao.setId(id);


        // propostaRepository.findById(id);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();

        try {

            associaCartaoPropostaClient = new AssociaCartaoPropostaClient() {
                @Override
                public CartaoResponse consulta(AssociaCartaoPropostaRequest request) {
                    return null;
                }
            };



            AssociaCartaoPropostaRequest associaCartaoPropostaRequest = new AssociaCartaoPropostaRequest( id );
            CartaoResponse resultadoDaConsulta = associaCartaoPropostaClient.consulta(associaCartaoPropostaRequest);

            propostaParaAtualizarCartao.setNumerocartao(resultadoDaConsulta.getId());
            propostaRepository.save(propostaParaAtualizarCartao);
        } catch (FeignException.UnprocessableEntity unprocessableEntity){

        }

        URI location = uriBuilder.path("/api/cartoes/{id}")
                .buildAndExpand(propostaParaAtualizarCartao.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
*/

}
