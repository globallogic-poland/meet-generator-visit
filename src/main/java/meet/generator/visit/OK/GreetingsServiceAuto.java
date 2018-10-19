package meet.generator.visit.OK;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import java.util.UUID;

import static meet.generator.visit.OK.GreetingsStreams.OUTPUT;

@Slf4j
@EnableBinding(GreetingsStreams.class)
public class GreetingsServiceAuto {

    @Bean
    @InboundChannelAdapter(channel = OUTPUT, poller = @Poller(fixedDelay = "1000"))
    public MessageSource<Greetings> generate() {
        log.info("generate message");
        return () -> MessageBuilder
                .withPayload(Greetings.builder()
                        .message(UUID.randomUUID().toString())
                        .timestamp(System.currentTimeMillis())
                        .build())
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
    }


}