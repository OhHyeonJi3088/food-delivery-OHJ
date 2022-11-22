package fooddeliveryohj.domain;

import fooddeliveryohj.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="NotificationLog_table")
@Data

public class NotificationLog  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String message;


    public static NotificationLogRepository repository(){
        NotificationLogRepository notificationLogRepository = CustomerApplication.applicationContext.getBean(NotificationLogRepository.class);
        return notificationLogRepository;
    }




    public static void alertKakaoTalk(Accepted accepted){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        */
        repository().findById(accepted.getId()).ifPresent(notificationLog->{
            
            notificationLog.message = "StoreOrder accepted"; // do something
            repository().save(notificationLog);


         });
        

        
    }
    public static void alertKakaoTalk(Rejected rejected){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        */
        repository().findById(rejected.getId()).ifPresent(notificationLog->{
            
            notificationLog.message = "StoreOrder rejected"; // do something
            repository().save(notificationLog);


         });
        

        
    }
    public static void alertKakaoTalk(Cooked cooked){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        */
        repository().findById(cooked.getId()).ifPresent(notificationLog->{
            
            notificationLog.message = "StoreOrder cooked"; // do something
            repository().save(notificationLog);


         });
        

        
    }
    public static void alertKakaoTalk(Paid paid){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        */
        repository().findById(paid.getId()).ifPresent(notificationLog->{
            
            notificationLog.message = "Payment paid"; // do something
            repository().save(notificationLog);


         });
        

        
    }
    public static void alertKakaoTalk(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        */
        repository().findById(orderPlaced.getId()).ifPresent(notificationLog->{
            
            notificationLog.message = "Order orderPlaced"; // do something
            repository().save(notificationLog);


         });
        

        
    }
    public static void alertKakaoTalk(DeliveryStarted deliveryStarted){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        */
        repository().findById(deliveryStarted.getId()).ifPresent(notificationLog->{
            
            notificationLog.message = "Delivery started"; // do something
            repository().save(notificationLog);


         });
        

        
    }
    public static void alertKakaoTalk(CouponPublished couponPublished){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        */
        repository().findById(couponPublished.getId()).ifPresent(notificationLog->{
            
            notificationLog.message = "StoreOrder couponPublished"; // do something
            repository().save(notificationLog);


         });
        

        
    }


}
