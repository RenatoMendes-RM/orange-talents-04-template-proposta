package br.com.ot4rmsproposta.propostaot4rms.Biometria;

import br.com.ot4rmsproposta.propostaot4rms.Cartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface BiometriaRepository extends JpaRepository <Biometria, Long> {

    @Query("select b from Biometria b where b.cartao = ?1 and b.fingerprintdecode = ?2")
    List<Biometria> LocalizarCartaoBiometria(Optional<Cartao> cartao, String fingerprintdecode);

}
