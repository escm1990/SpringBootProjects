package com.example.kafka.producer.config;

import java.util.Map;
import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.kafka.producer.dto.Mensaje;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServerUrl;

    @Value("${cloudkarafka-username}")
    private String cloudKarafkaUserName;

    @Value("${cloudkarafka-password}")
    private String cloudKarafkaPassword;

    private final String jaasTemplate = "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";";

    @Bean
    public Map<String, Object> producerConfig()  {

        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerUrl);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put(JsonSerializer.TYPE_MAPPINGS, "Mensaje:com.example.kafka.producer.dto.Mensaje");
        props.put("sasl.mechanism", "SCRAM-SHA-256");        
        props.put("sasl.jaas.config", String.format(jaasTemplate, cloudKarafkaUserName, cloudKarafkaPassword));
        props.put("security.protocol", "SASL_SSL");
        props.put("enable.idempotence" , "false");

        return props;
    }

    @Bean
    public ProducerFactory<Integer, Mensaje> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }


    @Bean
    public KafkaTemplate<Integer, Mensaje> kafkaTemplate(ProducerFactory<Integer, Mensaje> producerFactory) {
        return new KafkaTemplate<Integer, Mensaje>(producerFactory);
    }

}

