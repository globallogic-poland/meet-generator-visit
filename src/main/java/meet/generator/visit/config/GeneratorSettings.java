package meet.generator.visit.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Component
@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "generator")
public class GeneratorSettings {

    @Valid
    private Data data = new Data();

    @Valid
    private Weights weights = new Weights();

    @Setter
    @Getter
    public static class Data {

        @NotEmpty
        private List<String> doctors;

        @NotEmpty
        private List<String> clinics;

        @NotEmpty
        private List<String> patients;
    }

    @Setter
    @Getter
    public static class Weights {

        @NotEmpty
        private List<Double> doctors;

        @NotEmpty
        private List<Double> clinics;

        @NotEmpty
        private List<Double> patients;
    }

}
