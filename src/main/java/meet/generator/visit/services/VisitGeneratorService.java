package meet.generator.visit.services;

import meet.generator.visit.model.Visit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class VisitGeneratorService {

    //TODO: stream which reads this data from microservices (by Kafka) (and microservices from their casandras)   or   read all to memory and then stream
    private final static List<String> DOCTORS = List.of("Watson", "Jekyll", "Dolittle", "Ford", "Van Helsing", "House", "Johnson");
    private final static List<String> CLINICS = List.of("Luxmed", "7", "Staford", "Clinic1", "Clinic2");
    private final static List<String> PATIENTS = List.of("Mazurek", "Patient1", "Patient2", "Patient3", "Patient4", "Patient4", "Patient4");
    private final static List<Double> DOCTORS_WEIGHTS = List.of(0.1, 0.1, 0.1, 0.5, 0.1);
    private final static List<Double> CLINICS_WEIGHTS = List.of(0.1, 0.2, 0.5, 0.1, 0.1);
    private final static List<Double> PATIENTS_WEIGHTS = List.of(0.1, 0.2, 0.5, 0.1, 0.1);

    public Visit generate() {
        return Visit.builder()
                .id(UUID.randomUUID().toString())
                .doctorId(random(DOCTORS_WEIGHTS, DOCTORS))
                .clinicId(random(CLINICS_WEIGHTS, CLINICS))
                .patientId(random(PATIENTS_WEIGHTS, PATIENTS))
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
