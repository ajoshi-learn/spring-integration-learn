package edu.arturjoshi.ex1.flow;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@Configuration
public class IntegrationFlowConfiguration {

    @Bean
    public MessageChannel helloChannel() {
        return MessageChannels.direct().get();
    }

    @Bean
    public IntegrationFlow helloWorldFlow(MessageChannel helloChannel) {
        return IntegrationFlows.from(helloChannel).handle("myHelloService", "sayHello").get();
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return strings -> helloChannel().send(MessageBuilder.withPayload("world").build());
    }
}
