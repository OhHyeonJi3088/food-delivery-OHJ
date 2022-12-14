package fooddeliveryohj.domain;

import fooddeliveryohj.domain.OrderPlaced;
import fooddeliveryohj.domain.OrderCanceled;
import fooddeliveryohj.AppApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String preference;
    
    
    
    
    
    private String options;
    
    
    
    @Embedded
    
    private Address address;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        fooddeliveryohj.external.Payment payment = new fooddeliveryohj.external.Payment();
        // mappings goes here
        AppApplication.applicationContext.getBean(fooddeliveryohj.external.PaymentService.class)
            .pay(payment);


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }
    @PostRemove
    public void onPostRemove(){


        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){
    }
    @PreRemove
    public void onPreRemove(){
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = AppApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void cancel(Rejected rejected){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        */
        repository().findById(rejected.getId()).ifPresent(order->{
            
            order.status = "order.rejected"; // do something
            repository().save(order);


         });
        

        
    }
    public static void updateStatus(Accepted accepted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        */
        repository().findById(accepted.getId()).ifPresent(order->{
            
            order.status = "order.accepted"; // do something
            repository().save(order);


         });
        

        
    }
    public static void updateStatus(Rejected rejected){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        */
        repository().findById(rejected.getId()).ifPresent(order->{
            
            order.status = "order.rejected"; // do something
            repository().save(order);


         });
        

        
    }
    public static void updateStatus(Started started){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        */
        repository().findById(started.getId()).ifPresent(order->{
            
            order.status = "cooking.started"; // do something
            repository().save(order);


         });
        

        
    }


}
