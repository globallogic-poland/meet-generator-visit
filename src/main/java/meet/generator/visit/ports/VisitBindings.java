package meet.generator.visit.ports;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface VisitBindings {

    String INPUT = "visits-in";
    String OUTPUT = "visits-out";

    @Input(INPUT)
    SubscribableChannel visitsIn();

    @Output(OUTPUT)
    MessageChannel visitsOut();
}