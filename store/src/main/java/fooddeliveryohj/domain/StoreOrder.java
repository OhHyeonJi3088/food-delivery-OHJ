package fooddeliveryohj.domain;

import fooddeliveryohj.domain.Cooked;
import fooddeliveryohj.domain.Accepted;
import fooddeliveryohj.domain.Rejected;
import fooddeliveryohj.domain.Started;
import fooddeliveryohj.domain.CouponPublished;
import fooddeliveryohj.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="StoreOrder_table")
@Data

public class StoreOrder  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String preference;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String test;

    @PostPersist
    public void onPostPersist(){


        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();



        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();



        Started started = new Started(this);
        started.publishAfterCommit();



        CouponPublished couponPublished = new CouponPublished(this);
        couponPublished.publishAfterCommit();

    }

    public static StoreOrderRepository repository(){
        StoreOrderRepository storeOrderRepository = StoreApplication.applicationContext.getBean(StoreOrderRepository.class);
        return storeOrderRepository;
    }



    public void finishCook(){
    }
    public void accept(){
    }
    public void reject(){
    }
    public void startCook(){
    }

    public static void addToOrderLists(Paid paid){

        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        */

        /** Example 2:  finding and process
        */
        repository().findById(paid.getId()).ifPresent(storeOrder->{
            
            storeOrder.status = "storeOrder.added"; // do something
            repository().save(storeOrder);


         });
        

        
    }
    public static void notifyOrderCanceled(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        */

        /** Example 2:  finding and process
        */
        repository().findById(orderCanceled.getId()).ifPresent(storeOrder->{
            
            storeOrder.status = "storeOrder.canceled"; // do something
            repository().save(storeOrder);


         });
        

        
    }


}
