# MicroservicesPoc2

we have two microservices USER_SERVICE and DEPARTMENT_SERVICE

Both are spring boot applications and communicating with each other.

For every User-Service request, User service is fetching information from Department-Service by calling it using RestTemplet call.

We have created a method to fetch the User and its Department so there is a call from USER_SERVICE to DEPARTMENT_SERVICE using rest API call

Now instead of direct calling DEPARTMENT_SERVICE from USER_SERVICE, we are using Eureka server (as a service registry).
Its name is SERVICE_REGISTRY and all the microservices are connected to this service registry.
In this way, we can have an idea of what are the different microservices and what are their ports and URLs.

After that, we have created an API gateway. It’s just a gateway for all the APIs that we have in our microservices. So all the requests shouldn’t be going directly to the microservices it should be going through API gateway and where we redirect as per specific microservices URL pattern. So API gateway is responsible to traverse the appropriate microservice as per the incoming request.

Now if a particular microservice is down within the architecture in API-Gateway we have configured a specific timeout and a fallback method to notify other microservices that this particular microservice is down. We have implemented this by using Hystrix circuit breaker (we can also use resilience4j).
By implementing this we can also visualize how much our endpoints are failing and how much is getting successful. For this, we have implemented a Hystrix dashboard to monitor all microservices and their status.

After that, we have implemented a config server. For this, we have created a git repository and all the common configurations which are used in all the microservices in our architecture are placed there. For this, we have created a cloud-config server that will read that git repository and it will give all the common configurations to all the microservices connected to it.

After that, we have added distributed logging. There are multiple microservices in the live project so we should be able to identify which microservices are failing and where our request is traversing for that we have used Zipkin and sleuth libraries. We have created a Zipkin server and then we have created a Zipkin client and sleuth library in all our microservices. So sleuth provides multiple options over there. We would be able to identify which service is being called, what is its traceId, and what is its spanId.
Trace id is the unique id along with the entire request. And SpanId is specific for every microservice.
