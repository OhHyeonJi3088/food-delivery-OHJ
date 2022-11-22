package fooddeliveryohj.domain;

import fooddeliveryohj.domain.*;
import fooddeliveryohj.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Started extends AbstractEvent {

    private Long id;
    private String foodId;
    private String preference;
    private String orderId;
    private String status;
}


