package br.com.ot4rmsproposta.propostaot4rms.Biometria;

import br.com.ot4rmsproposta.propostaot4rms.Cartao.Cartao;
import br.com.ot4rmsproposta.propostaot4rms.Cartao.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/biometria")
public class BiometriaController {

    @Autowired
    private BiometriaRepository biometriaRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @PostMapping ("/{idCartao}")
    public ResponseEntity<?> adicionaBiometria (@PathVariable String idCartao,
                                                @RequestBody @Valid BiometriaRequest biometriaRequest,
                                                UriComponentsBuilder uriComponentsBuilder) {

        Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
        if(!cartao.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão não encontrado");
        }
        Biometria biometria = biometriaRequest.paraBiometria(cartao.get());
        List<Biometria> biometriaCartao = biometriaRepository.LocalizarCartaoBiometria(cartao, biometria.getFingerPrintDecode());
        if (biometriaCartao.size() > 0) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Biometria já foi cadastrada anteriormente.");
        }
        biometriaRepository.save(biometria);
        URI location = uriComponentsBuilder.path("/api/biometria/{id}")
                .buildAndExpand(biometria.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPeloIdBiometria(@PathVariable Long id) {
        Optional<Biometria> possivelBiometria = biometriaRepository.findById(id);
        return possivelBiometria
                .map(biometria -> ResponseEntity.ok()
                        .body("Data do cadastro de Biometria: " + biometria.getDatabiometria().toString()))
                .orElse(ResponseEntity.notFound().build());
    }
}
