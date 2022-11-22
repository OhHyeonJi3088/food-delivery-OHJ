package fooddeliveryohj.domain;

import fooddeliveryohj.domain.*;
import fooddeliveryohj.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CouponPublished extends AbstractEvent {

    private Long id;
    private String foodId;
    private String preference;
    private String orderId;
    private String status;

    public CouponPublished(StoreOrder aggregate){
        super(aggregate);
    }
    public CouponPublished(){
        super();
    }
}
