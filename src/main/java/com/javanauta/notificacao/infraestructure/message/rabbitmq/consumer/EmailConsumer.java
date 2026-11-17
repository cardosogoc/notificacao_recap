package com.javanauta.notificacao.infraestructure.message.rabbitmq.consumer;

import com.javanauta.notificacao.business.EmailService;
import com.javanauta.notificacao.business.dto.TarefasDTO;
import com.javanauta.notificacao.infraestructure.message.rabbitmq.config.RabbitMqConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailConsumer {

    private final EmailService service;

    @RabbitListener(queues = RabbitMqConfig.FILA_EMAIL)
    public void eviarEmail(TarefasDTO dto){
        service.enviaEmail(dto);
    }
}
