package meet.generator.visit.services;

import lombok.AllArgsConstructor;
import meet.generator.visit.config.GeneratorSettings;
import meet.generator.visit.dto.Visit;
import meet.generator.visit.repos.ClinicRepo;
import meet.generator.visit.repos.DoctorRepo;
import meet.generator.visit.repos.PatientRepo;
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
    private final DoctorRepo doctorRepo;
    private final PatientRepo patientRepo;
    private final ClinicRepo clinicRepo;

    public Visit generate() {
        return Visit.builder()
                .id(UUID.randomUUID().toString())
                .doctor(random(settings.getWeights().getDoctors(), doctorRepo.getAll()))
                .clinic(random(settings.getWeights().getClinics(), clinicRepo.getAll()))
                .patient(random(settings.getWeights().getPatients(), patientRepo.getAll()))
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
