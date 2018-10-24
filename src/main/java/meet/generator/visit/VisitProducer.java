package meet.generator.visit;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meet.generator.visit.dto.Visit;
import meet.generator.visit.ports.ProducerProvider;
import meet.generator.visit.ports.VisitGeneratorBindings;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.reactive.StreamEmitter;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static meet.generator.visit.ports.VisitGeneratorBindings.VISITS;

@Slf4j
@AllArgsConstructor
@EnableBinding(VisitGeneratorBindings.class)
public class VisitProducer {

    private final ProducerProvider<Visit> producerProvider;

    @StreamEmitter
    @Output(VISITS)
    public Flux<Visit> send() {
//        return producerProvider.create(1_000_000);
        return Flux.interval(Duration.ofMillis(250))
                .zipWith(producerProvider.create(1_000_000), (l, visit) -> visit);
    }

}