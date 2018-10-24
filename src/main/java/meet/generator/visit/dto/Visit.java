package meet.generator.visit.dto;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Value
public class Visit {

    String id;

    Doctor doctor;

    Patient patient;

    Clinic clinic;

    Disease diagnosedDisease;

    @Singular
    List<Drug> prescribedDrugs;

    double clinicCost;

    double clinicIncome;

    long appointmentTime;

}
