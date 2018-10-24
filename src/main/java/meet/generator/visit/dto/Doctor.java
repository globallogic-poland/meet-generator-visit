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
public class Doctor {

    private String id;

    private String firstName;

    private String lastName;

    private String district;

    private String city;

    private String country;

    @Singular
    private Set<Specialization> specializations;

}
