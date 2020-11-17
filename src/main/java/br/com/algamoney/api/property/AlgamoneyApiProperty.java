package br.com.algamoney.api.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;

@ConfigurationProperties("algamoney")
public class AlgamoneyApiProperty {

    @Getter
    private final List<String> originsPermitidas = Arrays.asList("http://localhost:8000");

    @Getter
    private final Seguranca seguranca = new Seguranca();

    @Getter @Setter
    public static class Seguranca {

        private boolean enableHttps;

    }

}
