package meet.generator.visit.adapters;

import lombok.extern.slf4j.Slf4j;
import meet.generator.visit.ports.ChannelSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(ChannelSink.class)
public class ExampleMessageSink {

    @StreamListener("test-sink")
    public void receive(String payload) {
        log.info("Data received: " + payload);
    }
}
	