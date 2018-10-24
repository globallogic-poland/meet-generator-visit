package meet.generator.visit.ports;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface VisitGeneratorBindings {

    String VISITS = "visits";

    @Output(VISITS)
    MessageChannel visits();
}