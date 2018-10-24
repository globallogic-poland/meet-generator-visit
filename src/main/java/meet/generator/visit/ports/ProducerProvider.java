package meet.generator.visit.ports;

import reactor.core.publisher.Flux;

public interface ProducerProvider<T> {

    Flux<T> create(long count);
}
