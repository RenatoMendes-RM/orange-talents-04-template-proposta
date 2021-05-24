package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropostaRepository extends JpaRepository <Proposta, Long> {

    boolean existsByDocumento(String documento);

}
