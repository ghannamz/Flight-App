# Flight Application Services

## The flight app includes the following different microservices:
airplane-service
boarding-pass-service
flight-service
passenger-service
ticket-service
eureka-service


## The required APIs for the assignment are:
ticket-service/ticket/isExist/{ticket_id}
ticket-service/ticket/coupon/{coupon_id}/{price}
boarding-pass-service/boarding/checkedIn/{destination_id}/{baggage_id}


Local in-memory cache mechanism is implemented under ticket-service.

The app uses spring cloud netflix eureka server for Service Discovery Pattern.

The app uses spring cloud netflix hystrix for Circuit Breaker Pattern.
