package fooddeliveryohj.external;

import lombok.Data;
import java.util.Date;
@Data
public class Order {

    private Long id;
    private String foodId;
    private String customerId;
    private String preference;
    private String options;
    private Object address;
    private String status;
}


