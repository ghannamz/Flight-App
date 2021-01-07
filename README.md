# Flight Application Services

## The flight app includes the following different microservices:
<li>airplane-service
<li>boarding-pass-service
<li>flight-service
<li>passenger-service
<li>ticket-service
<li>eureka-service


## The required APIs for the assignment are:
<li>ticket-service/ticket/isExist/{ticket_id}
<li>ticket-service/ticket/coupon/{coupon_id}/{price}
<li>boarding-pass-service/boarding/checkedIn/{destination_id}/{baggage_id}


Local in-memory cache mechanism is implemented under ticket-service.

The app uses spring cloud netflix eureka server for Service Discovery Pattern.

The app uses spring cloud netflix hystrix for Circuit Breaker Pattern.
