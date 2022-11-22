package fooddeliveryohj.domain;

import fooddeliveryohj.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String address;
    private Long orderId;
}
