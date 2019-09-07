package com.devglan.springbootrabbitmq.config;
import com.devglan.springbootrabbitmq.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final AMQPProducer producer;

    public Runner(AMQPProducer producer, RabbitTemplate rabbitTemplate, RabbitMQProperties rabbitMQProperties) {
        this.producer = producer;
    }

    @Override
    public void run(String... args) throws Exception {
        Notification msg = new Notification();
        msg.setNotificationType("Email");
        msg.setMsg("A new email from Devglan");
        producer.sendMessage(msg);
    }

}
