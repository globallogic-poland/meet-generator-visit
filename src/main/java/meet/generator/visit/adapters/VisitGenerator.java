package meet.generator.visit.adapters;

import lombok.extern.slf4j.Slf4j;
import meet.generator.visit.config.WeightsSettings;
import meet.generator.visit.dto.Clinic;
import meet.generator.visit.dto.Doctor;
import meet.generator.visit.dto.Patient;
import meet.generator.visit.dto.Visit;
import meet.generator.visit.ports.Generator;

import java.util.List;
import java.util.Random;
import java.util.UUID;

//@RequiredArgsConstructor
@Slf4j
public class VisitGenerator implements Generator<Visit> {

    private final WeightsSettings weights;

    private final Random random = new Random();

    private final List<Doctor> doctors;

    private final List<Patient> patients;

    private final List<Clinic> clinics;

    public VisitGenerator(DataPuller dataPuller, WeightsSettings weights) {
        this.weights = weights;
        this.doctors = dataPuller.pullDoctors(); // Really!?
        this.patients = dataPuller.pullPatients();
        this.clinics = dataPuller.pullClinics();
    }

    @Override
    public Visit next() {
        return Visit.builder()
                .id(UUID.randomUUID().toString())
//                .doctor(random(weights.getDoctors(), dataPuller.pullDoctors()))
//                .clinic(random(weights.getClinics(), dataPuller.pullClinics()))
//                .patient(random(weights.getPatients(), dataPuller.pullPatients()))
                .doctor(random(doctors))
                .clinic(random(clinics))
                .patient(random(patients))
                .build();
    }

    private <T> T random(List<T> items) {
        int size = items.size();
        int randomValue = random.nextInt(size);
        return items.get(randomValue);
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
