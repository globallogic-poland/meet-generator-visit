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

import static meet.generator.visit.ports.VisitGeneratorBindings.VISITS;

@Slf4j
@AllArgsConstructor
@EnableBinding(VisitGeneratorBindings.class)
public class VisitProducer {

    private final ProducerProvider<Visit> producerProvider;

//    private final ProducerSettings settings;

//    @Bean
//    @InboundChannelAdapter(channel = VISITS, poller = @Poller(fixedDelay = "1000"))
//    public MessageSource<Visit> generate() {
//        return () -> MessageBuilder
//                .withPayload(visitGenerator.next())
//                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
//                .build();
//    }

    @StreamEmitter
    @Output(VISITS)
    public Flux<Visit> send() {
//        return producerProvider.create(settings.getPatientCount());
        return producerProvider.create(5);
    }

}