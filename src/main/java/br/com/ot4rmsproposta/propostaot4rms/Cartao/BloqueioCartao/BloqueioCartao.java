package br.com.ot4rmsproposta.propostaot4rms.Cartao.BloqueioCartao;

import br.com.ot4rmsproposta.propostaot4rms.Cartao.Cartao;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "bloqueiocartao")
public class BloqueioCartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime bloqueadoEm = LocalDateTime.now();
    @NotBlank
    private String ipSolicitante;
    @NotBlank
    private String agenteDoUsuario;
    @NotNull
    @OneToOne
    @JoinColumn(name = "idCartao")
    private Cartao cartao;

    @Deprecated
    public BloqueioCartao() {
    }

    public BloqueioCartao(@NotBlank String ipSolicitante
            , @NotBlank String agenteDoUsuario
            , @NotNull @Valid Cartao cartao) {
        this.ipSolicitante = ipSolicitante;
        this.agenteDoUsuario = agenteDoUsuario;
        this.cartao = cartao;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getBloqueadoEm() {
        return bloqueadoEm;
    }

    public String getIpSolicitante() {
        return ipSolicitante;
    }

    public String getAgenteDoUsuario() {
        return agenteDoUsuario;
    }

    public Cartao getCartao() {
        return cartao;
    }
}