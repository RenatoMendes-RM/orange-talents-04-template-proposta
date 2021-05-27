package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Endereco {

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;


    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String cep;

    /*
     * @Deprecated  apenas para uso do hibernete.
     * */
    @Deprecated
    Endereco() { }

    public Endereco(String logradouro,
                    String numero,
                    String complemento,
                    String bairro,
                    String cidade,
                    String estado,
                    String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}


