package meet.generator.visit.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Clinic {

    String id;
    
    String name;

    String district;

    String city;

    String country;

}
