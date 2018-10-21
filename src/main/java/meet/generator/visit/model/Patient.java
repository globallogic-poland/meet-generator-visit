package meet.generator.visit.model;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class Patient {

    String id;

    String name;

    int age;

    Sex sex;

    Set<String> chronicDiseases;

    String district;

    String city;

    String country;

}
