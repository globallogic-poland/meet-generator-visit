package meet.generator.visit.adapters;

import lombok.AllArgsConstructor;
import meet.generator.visit.config.WeightsSettings;
import meet.generator.visit.dto.Visit;
import meet.generator.visit.ports.Generator;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@AllArgsConstructor
public class VisitGenerator implements Generator<Visit> {

    private DataPuller dataPuller;

    private final WeightsSettings weights;

    @Override
    public Visit next() {
        return Visit.builder()
                .id(UUID.randomUUID().toString())
                .doctor(random(weights.getDoctors(), dataPuller.pullDoctors()))
                .clinic(random(weights.getClinics(), dataPuller.pullClinics()))
                .patient(random(weights.getPatients(), dataPuller.pullPatients()))
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
