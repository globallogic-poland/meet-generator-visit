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

    // TODO: consider VisitResult

    Disease diagnosedDisease;

    @Singular
    List<Drug> prescribedDrugs;

    double clinicCost;

    double clinicIncome;

    // TODO: @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDateTime appointmentTime;

}
