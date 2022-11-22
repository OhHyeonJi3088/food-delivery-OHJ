# food-delivery-OHJ

# 이벤트 스토밍

![image](https://user-images.githubusercontent.com/91641815/203244063-cdace5b5-f4b3-406f-8ab5-47569c056667.png)

# 기능적 요구사항
1. 고객이 메뉴를 선택하여 주문한다.
2. 고객이 선택한 메뉴에 대해 결제한다.
3. 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다
4. 상점주는 주문을 수락하거나 거절할 수 있다
5. 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다
6. 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다
7. 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다
8. 라이더가 해당 요리를 pick 한후, pick했다고 앱을 통해 통보한다.
9. 고객이 주문상태를 중간중간 조회한다
10. 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다
11. 고객이 요리를 배달 받으면 배송확인 버튼을 탭하여, 모든 거래가 완료된다

# 추가된 2가지 기능
1. 상점주는 쿠폰을 발행해 고객에게 카톡으로 알림을 보낸다
2. 상점주는 주문수락때와 거절 시점에 시스템에 상태를 입력한다

# Saga(Pub/Sub)
[추가기능1]
![image](https://user-images.githubusercontent.com/91641815/203246773-d06bc2f4-4e14-45b7-b840-a855ce3f7c0f.png)
![image](https://user-images.githubusercontent.com/91641815/203246965-be1a149e-9e0f-4098-a45f-59baa99158a4.png)
[추가기능2]
![image](https://user-images.githubusercontent.com/91641815/203252351-780a3bce-5e9e-4b13-bfe7-750781d28a0c.png)
![image](https://user-images.githubusercontent.com/91641815/203252269-ace7a3de-4ee7-46c4-8daf-928ce5aeb2d6.png)

# CQRS
```java
// 주문이 들어오면 주문리스트 대시보드(View) Repo에 INSERT 
@StreamListener(KafkaProcessor.INPUT)
public void whenOrderPlaced_then_CREATE_1(
    @Payload OrderPlaced orderPlaced
) {
    try {
        if (!orderPlaced.validate()) return;

        // view 객체 생성
        OrderList orderList = new OrderList();
        // view 객체에 이벤트의 Value 를 set 함
        orderList.setOrderId(orderPlaced.getOrderId());
        // view 레파지 토리에 save
        orderListRepository.save(orderList);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

# Compensataion/Correlation
```java
@StreamListener(value = KafkaProcessor.INPUT, condition = "headers['type']=='OrderCancelled'")
    public void wheneverOrderCancelled_IncreaseFood(@Payload OrderCancelled orderCancelled) {
        OrderCancelled event = orderCancelled;
        Food.increaseFood(event);
    }
    
    
    public static void increaseFood(OrderCancelled orderCancelled) {
        FoodRepository().findById(Long.valueOf(orderCancelled.getFoodId())).ifPresent(stock->{
            Food.setFood(stock.getFood()++);
            FoodRepository().save(Food);
        });
    }
```

# Request/Response
![image](https://user-images.githubusercontent.com/91641815/203259097-c7fbe7eb-1748-47b8-89c9-45df42dc998a.png)
![image](https://user-images.githubusercontent.com/91641815/203259156-3a04c456-d968-45d9-bc2e-572173fbb212.png)

# Circuit Breaker
```java
server:
  port: 8088
feign:
  hystrix:
    enabled: true
hystrix:
  command:
     default:
      execution.isolation.thread.timeoutInMilliseconds: 2000
spring:
  application:
    name: app
```

# Gateway/Ingress
![image](https://user-images.githubusercontent.com/91641815/203247906-b205c254-6528-4e70-af85-f6c063833e08.png)
