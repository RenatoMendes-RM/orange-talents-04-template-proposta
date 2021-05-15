package br.com.ot4rmsproposta.propostaot4rms.novaProposta;

public class EnderecoRequest {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;

    public EnderecoRequest(String logradouro,
                           String numero,
                           String complemento,
                           String bairro,
                           String cidade,
                           String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }


    @Override
    public String toString() {
        return "EnderecoRequest{" +
                "logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
