package meet.generator.visit.adapters;

import lombok.RequiredArgsConstructor;
import meet.generator.visit.dto.Visit;
import meet.generator.visit.ports.Generator;
import meet.generator.visit.ports.ProducerProvider;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class VisitProducerProvider implements ProducerProvider<Visit> {

    private final Generator<Visit> visitGenerator;

    @Override
    public Flux<Visit> create(long count) {
        return Flux.fromIterable(() -> visitGenerator)
                .take(count);
    }

}
