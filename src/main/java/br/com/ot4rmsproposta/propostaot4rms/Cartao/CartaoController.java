package br.com.ot4rmsproposta.propostaot4rms.Cartao;

import br.com.ot4rmsproposta.propostaot4rms.novaProposta.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cartoes")
public class CartaoController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private CartaoClientAPI cartaoClientAPI;
}
