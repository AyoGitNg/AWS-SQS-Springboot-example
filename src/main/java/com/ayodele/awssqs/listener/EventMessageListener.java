package com.ayodele.awssqs.listener;

import com.ayodele.awssqs.model.EventMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import static com.ayodele.awssqs.AwsSqsApplication.QUEUE_NAME;

@Component
public class EventMessageListener {

    private static final Logger LOG = LoggerFactory.getLogger(EventMessageListener.class);

    @SqsListener(QUEUE_NAME)
    private void receiveMessage(EventMessage message, @Header("SenderId") String senderId,
                                @Header("ApproximateFirstReceiveTimestamp") String approximateFirstReceiveTimestamp) {
        LOG.debug("Received SQS message {}", message);
        LOG.debug("Received SQS message {}", senderId);
        LOG.debug("Received SQS message {}", approximateFirstReceiveTimestamp);
    }

}
