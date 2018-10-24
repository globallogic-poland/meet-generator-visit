package meet.generator.visit.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Component
@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "generator.weights")
public class WeightsSettings {

    @NotEmpty
    private List<Double> doctors;

    @NotEmpty
    private List<Double> clinics;

    @NotEmpty
    private List<Double> patients;

}
