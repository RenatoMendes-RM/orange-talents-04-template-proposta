package br.com.ot4rmsproposta.propostaot4rms.Biometria;

import br.com.ot4rmsproposta.propostaot4rms.Cartao.Cartao;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Biometria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String fingerprintdecode;

    @ManyToOne
    @JoinColumn(name = "idcartao")
    private Cartao cartao;

    @CreationTimestamp
    private LocalDate databiometria = LocalDate.now();

    public Biometria() {
    }

    public Biometria(String fingerprintdecode, Cartao cartao) {
        this.fingerprintdecode = fingerprintdecode;
        this.cartao = cartao;
    }

    public Long getId() {
        return id;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDate getDatabiometria() {
        return databiometria;
    }

    public String getFingerPrintDecode() {
        return fingerprintdecode;
    }
}
