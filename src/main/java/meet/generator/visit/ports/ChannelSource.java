package meet.generator.visit.ports;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ChannelSource {
    @Output("test-OK")
    MessageChannel sampleSource();
}
