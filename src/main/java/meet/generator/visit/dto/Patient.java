package meet.generator.visit.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
//@Value
@Builder
public class Patient {

    String id;

    String firstName;

    String lastName;

    int age;

    Sex sex;

    @Singular
    Set<Disease> chronicDiseases;

    String district;

    String city;

    String country;

}
