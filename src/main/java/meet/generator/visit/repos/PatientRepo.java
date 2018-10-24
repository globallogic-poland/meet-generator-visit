package meet.generator.visit.repos;

import meet.generator.visit.dto.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepo {

    private List<Patient> patients;

    public Patient get(int i) {
        return this.patients.get(i);
    }

    public void save(Patient doctor) {
        patients.add(doctor);
    }

    public List<Patient> getAll() {
        return patients;
    }

    public void saveAll(List<Patient> doctors) {
        this.patients = doctors;
    }

}
