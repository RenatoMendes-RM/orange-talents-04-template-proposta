package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropostaRepository extends JpaRepository <Proposta, Long> {

    boolean existsByDocumento(String documento);

    @Query("select p from Proposta p where (p.numerocartao = '' OR p.numerocartao IS NULL) AND p.status = 'ELEGIVEL'")
    List<Proposta> LocalizarElegiveisSemCartao();
}

