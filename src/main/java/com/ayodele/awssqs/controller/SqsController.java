package com.ayodele.awssqs.controller;

import com.ayodele.awssqs.model.EventMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import static com.ayodele.awssqs.AwsSqsApplication.QUEUE_NAME;

@RestController
@RequestMapping("/message")
public class SqsController {

    private static final Logger LOG = LoggerFactory.getLogger(SqsController.class);

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public SqsController(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    @RequestMapping(value = "/message-processing-queue", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void sendMessageToMessageProcessingQueue(@RequestBody EventMessage message) {
        LOG.info("Going to send message {} over SQS", message);
        this.queueMessagingTemplate.convertAndSend(QUEUE_NAME, MessageBuilder.withPayload(message).build());
    }

}
