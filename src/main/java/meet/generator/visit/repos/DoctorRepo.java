package meet.generator.visit.repos;


import meet.generator.visit.dto.Doctor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepo {

    private List<Doctor> doctors;

    public Doctor get(int i) {
        return this.doctors.get(i);
    }

    public void save(Doctor doctor) {
        doctors.add(doctor);
    }

    public List<Doctor> getAll() {
        return doctors;
    }

    public void saveAll(List<Doctor> doctors) {
        this.doctors = doctors;
    }


}
