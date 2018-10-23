package meet.generator.visit.model;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class Patient {

    String id;

    String firstName;

    String lastName;

    int age;

    Sex sex;

    Set<String> chronicDiseases; // TODO: String -> Disease

    String district;

    String city;

    String country;

}
