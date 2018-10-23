package meet.generator.visit.services;

import lombok.AllArgsConstructor;
import meet.generator.visit.config.GeneratorSettings;
import meet.generator.visit.model.Visit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VisitGeneratorService {

    /* TODO: stream which reads this data from microservices (by Kafka)
    (and microservices from their casandras) or read all to memory and then stream */

    private final GeneratorSettings settings;

    public Visit generate() {
        return Visit.builder()
                .id(UUID.randomUUID().toString())
                .doctorId(random(settings.getWeights().getDoctors(), settings.getData().getDoctors()))
                .clinicId(random(settings.getWeights().getClinics(), settings.getData().getClinics()))
                .patientId(random(settings.getWeights().getPatients(), settings.getData().getPatients()))
                .build();
    }

    private <T> T random(List<Double> weights, List<T> items) {
        Random rand = new Random();
        double p = rand.nextDouble();
        double sum = 0.0;
        int i = 0;

        while ((sum < p) && (i < weights.size())) {
            sum += weights.get(i);
            i++;
        }
        return items.get(i - 1);
    }

}
