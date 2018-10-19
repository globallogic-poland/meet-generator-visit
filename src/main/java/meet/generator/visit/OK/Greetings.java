package meet.generator.visit.OK;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Greetings {
    private long timestamp;
    private String message;
}