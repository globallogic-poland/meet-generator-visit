package meet.generator.visit.adapters;

import lombok.extern.slf4j.Slf4j;
import meet.generator.visit.dto.Clinic;
import meet.generator.visit.dto.Doctor;
import meet.generator.visit.dto.Patient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Slf4j
@Component
public class DataPuller {

    private static final String PATIENTS_URI = "http://localhost:31100/patients";
    private static final String CLINICS_URI = "http://localhost:31200/clinics";
    private static final String DOCTORS_URI = "http://localhost:31300/doctors";

    private WebClient webClient = WebClient.builder().build();

    public List<Doctor> pullDoctors() {
        return consume(DOCTORS_URI, Doctor.class);
    }

    public List<Patient> pullPatients() {
        return consume(PATIENTS_URI, Patient.class);
    }

    public List<Clinic> pullClinics() {
        return consume(CLINICS_URI, Clinic.class);
    }

    private <T> List<T> consume(String uri, Class<T> aClass) {
        List<T> list = webClient.get().uri(uri)
                .retrieve().bodyToFlux(aClass)
                .take(6)
                .collectList()
                .block();
        log.info("List: {}", list);
        return list;
    }

}
