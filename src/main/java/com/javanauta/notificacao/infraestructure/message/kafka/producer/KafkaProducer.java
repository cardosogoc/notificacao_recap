package com.javanauta.notificacao.infraestructure.message.kafka.producer;

import com.javanauta.notificacao.business.dto.StatusTarefaDTO;
import com.javanauta.notificacao.infraestructure.exceptions.MensagemException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void enviarStatusTarefa(StatusTarefaDTO dto) {
        try {
            String json = objectMapper.writeValueAsString(dto);
            kafkaTemplate.send("status-notificacao", json);
        } catch (JacksonException e) {
            throw new MensagemException("Erro ao serializar o objeto");
        }
    }
}