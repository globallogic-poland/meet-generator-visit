package meet.generator.visit.ports;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface VisitBindings {

    String OUTPUT = "visits-out";

    @Output(OUTPUT)
    MessageChannel visitsOut();
}