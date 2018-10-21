package meet.generator.visit.services;

import meet.generator.visit.model.Disease;
import meet.generator.visit.model.Drug;
import meet.generator.visit.model.Visit;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class VisitGeneratorService {

    //TODO stream which reads this data from microservices (by Kafka) (and microservices from their casandras)   or   read all to memory and then stream
    private final static List<String> doctors = Arrays.asList("Watson", "Jekyll", "Dolittle", "Ford", "Van Helsing", "House", "Johnson");
    private final List<String> clinics = Arrays.asList("Luxmed", "7", "Staford", "Clinic1", "Clinic2");
    private final List<String> patients = Arrays.asList("Mazurek", "Patient1", "Patient2", "Patient3", "Patient4", "Patient4", "Patient4");
    private final double[]  doctorsWeights  = {0.1,0.1,0.1,0.5,0.1};
    private final double[]  clinicsWeights  = {0.1,0.2,0.5,0.1,0.1};
    private final double[]  patietsWeights  = {0.1,0.2,0.5,0.1,0.1};

    public Visit generate() {
        Visit visit = Visit.builder()
                .id(UUID.randomUUID().toString())
                .doctorId(random(doctorsWeights, doctors))
                .clinicId(random(clinicsWeights, clinics))
                .patientId(random(patietsWeights, patients))
                .build();
        return visit;
    }

    //TODO move to utils
    public static <T> T random(double[] weights, List<T> items){
        Random rand = new Random();
        double p = rand.nextDouble();
        double sum = 0.0;
        int i = 0;
        while((sum < p) && (i < weights.length)) {
            sum += weights[i];
            i++;
        }
        return items.get(i-1);
    }

}
