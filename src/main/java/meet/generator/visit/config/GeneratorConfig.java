package meet.generator.visit.config;

import meet.generator.visit.adapters.DataPuller;
import meet.generator.visit.adapters.VisitGenerator;
import meet.generator.visit.adapters.VisitProducerProvider;
import meet.generator.visit.dto.Visit;
import meet.generator.visit.ports.Generator;
import meet.generator.visit.ports.ProducerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorConfig {

    @Bean
    public ProducerProvider<Visit> doctorGenerator(Generator<Visit> visitGenerator) {
        return new VisitProducerProvider(visitGenerator);
    }

    @Bean
    public Generator<Visit> detailsGenerator(DataPuller dataPuller, WeightsSettings weightsSettings) {
        return new VisitGenerator(dataPuller, weightsSettings);
    }

    @Bean
    public DataPuller dataPuller() {
        return new DataPuller();
    }

}
