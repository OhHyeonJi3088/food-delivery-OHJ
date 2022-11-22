package fooddeliveryohj.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fooddeliveryohj.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fooddeliveryohj.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired NotificationLogRepository notificationLogRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_AlertKakaoTalk(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener AlertKakaoTalk : " + accepted + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakaoTalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_AlertKakaoTalk(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener AlertKakaoTalk : " + rejected + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakaoTalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_AlertKakaoTalk(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener AlertKakaoTalk : " + cooked + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakaoTalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_AlertKakaoTalk(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener AlertKakaoTalk : " + paid + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakaoTalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_AlertKakaoTalk(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener AlertKakaoTalk : " + orderPlaced + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakaoTalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_AlertKakaoTalk(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener AlertKakaoTalk : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakaoTalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CouponPublished'")
    public void wheneverCouponPublished_AlertKakaoTalk(@Payload CouponPublished couponPublished){

        CouponPublished event = couponPublished;
        System.out.println("\n\n##### listener AlertKakaoTalk : " + couponPublished + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakaoTalk(event);
        

        

    }

}


