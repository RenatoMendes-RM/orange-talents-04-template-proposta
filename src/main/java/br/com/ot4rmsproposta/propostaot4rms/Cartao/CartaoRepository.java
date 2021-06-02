package br.com.ot4rmsproposta.propostaot4rms.Cartao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {

    boolean existsById(String idCartao);


}
