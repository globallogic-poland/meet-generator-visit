package meet.generator.visit.repos;

import meet.generator.visit.dto.Clinic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClinicRepo {

    private List<Clinic> clinics;

    public Clinic get(int i) {
        return this.clinics.get(i);
    }

    public void save(Clinic clinic) {
        clinics.add(clinic);
    }

    public List<Clinic> getAll() {
        return clinics;
    }

    public void saveAll(List<Clinic> clinic) {
        this.clinics = clinic;
    }
}
