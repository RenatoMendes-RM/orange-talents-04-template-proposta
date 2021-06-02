package br.com.ot4rmsproposta.propostaot4rms.Biometria;

import br.com.ot4rmsproposta.propostaot4rms.Cartao.Cartao;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Base64;

public class BiometriaRequest {

    @NotNull
    private String fingerPrintEncode;

    public BiometriaRequest(@JsonProperty("fingerPrintEncode") String fingerPrintEncode) {
        this.fingerPrintEncode = fingerPrintEncode;
    }

    public Biometria paraBiometria(Cartao cartao) {
        String fingerPrintDecode = new String(Base64.getDecoder().decode(this.fingerPrintEncode));
        return new Biometria(fingerPrintDecode, cartao);
    }
}
