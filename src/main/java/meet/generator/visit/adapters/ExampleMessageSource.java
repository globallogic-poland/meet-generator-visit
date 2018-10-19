package meet.generator.visit.adapters;

import lombok.extern.slf4j.Slf4j;
import meet.generator.visit.ports.ChannelSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.support.GenericMessage;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@EnableBinding(ChannelSource.class)
public class ExampleMessageSource {

    private AtomicBoolean semaphore = new AtomicBoolean(true);

    @Bean
    @InboundChannelAdapter(channel = "test-OK", poller = @Poller(fixedDelay = "1000"))
    public org.springframework.integration.core.MessageSource<String> sendTestData() {
        log.info("generate message");
        return () -> new GenericMessage<>(semaphore.getAndSet(!semaphore.get()) ? "ping" : "pong");
    }
}