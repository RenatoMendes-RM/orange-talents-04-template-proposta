package br.com.ot4rmsproposta.propostaot4rms.Cartao.BloqueioCartao;

import br.com.ot4rmsproposta.propostaot4rms.Cartao.Cartao;
import br.com.ot4rmsproposta.propostaot4rms.Cartao.CartaoRepository;
import br.com.ot4rmsproposta.propostaot4rms.Cartao.CartaoClientAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/bloqueios")
public class BloqueioCartaoController {

    @Autowired
    private CartaoClientAPI cartaoClientAPI;
    @Autowired
    private CartaoRepository cartaoRepository;

    @PostMapping("/{idCartao}")
    public ResponseEntity<?> criaBloqueioCartao (@PathVariable("idCartao") String id
            , HttpServletRequest servletRequest
            , @RequestHeader(value = "User-Agent") String userAgent) {

        if (!cartaoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível localizar cartão.");
        }
        Optional<Cartao> cartao = cartaoRepository.findById(id);
        if(cartao.get().isBlocked()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Cartão já está bloqueado");
        }
        BloqueioCartao bloqueioCartao = new BloqueioCartao(servletRequest.getLocalAddr()
                , userAgent
                , cartao.get());
        cartao.get().setBloqueioCartao(bloqueioCartao);
        cartaoRepository.save(cartao.get());
        return ResponseEntity.ok().build();
    }
}