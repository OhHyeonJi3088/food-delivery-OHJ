package fooddeliveryohj.domain;

import fooddeliveryohj.domain.Paid;
import fooddeliveryohj.PayApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Payment_table")
@Data

public class Payment  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;

    @PostPersist
    public void onPostPersist(){


        Paid paid = new Paid(this);
        paid.publishAfterCommit();

    }

    public static PaymentRepository repository(){
        PaymentRepository paymentRepository = PayApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }




    public static void cancelPayment(Rejected rejected){

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        */
        repository().findById(rejected.getId()).ifPresent(payment->{
            
            payment.orderId = rejected.getId(); // do something
            repository().save(payment);


         });
        

        
    }
    public static void cancelPayment(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        */
        repository().findById(orderCanceled.getId()).ifPresent(payment->{
            
            payment.orderId = orderCanceled.getId(); // do something
            repository().save(payment);


         });
        

        
    }


}
