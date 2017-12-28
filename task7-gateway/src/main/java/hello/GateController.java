package hello;

//import com.netflix.discovery.DiscoveryClient;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
        import java.util.Random;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class GateController {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;
    
    @Autowired
    private EurekaClient eurekaClient;

    @RequestMapping("/clients")
    public List<ServiceInstance> clients(@RequestParam(value="name") String name) {
        return this.discoveryClient.getInstances(name);
    }

    @RequestMapping("/greeting")
    public String greeting() {
        Random rnd = new Random();

        //my-app1
        List<ServiceInstance> services1 = discoveryClient.getInstances("MY-APP1");
        EurekaDiscoveryClient.EurekaServiceInstance service1 = (EurekaDiscoveryClient.EurekaServiceInstance) services1.get(rnd.nextInt(services1.size()));
        String ip1 = service1.getInstanceInfo().getIPAddr();
        String greeting1 = this.restTemplate.getForObject("http://"+ip1+":8080/greeting", String.class);

        //my-app2
        List<ServiceInstance> services2 = discoveryClient.getInstances("MY-APP1");
        EurekaDiscoveryClient.EurekaServiceInstance service2 = (EurekaDiscoveryClient.EurekaServiceInstance) services2.get(rnd.nextInt(services2.size()));
        String ip2 = service2.getInstanceInfo().getIPAddr();
        String greeting2 = this.restTemplate.getForObject("http://"+ip2+":8080/greeting", String.class);


        return String.format("Got my-app1 answer: %s from ip %s, and my-app2 answer: %s from ip %s", greeting1, ip1, greeting2, ip2);
    }
    
    // USER SERVICE Driver CONTROLER 
     @RequestMapping("/sign-up/{username}/{password}/{name}/{surename}/{email}")
    public String singUpUser(@PathVariable String username, @PathVariable String password,@PathVariable String name, @PathVariable String surename, String email){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("MY-UBER_USER", false);
        String ip = instance.getIPAddr();
        String newUser = this.restTemplate.getForObject("http://"+ip+":8080/createNewUser?username="+username+ "&password=" + password + "&name="+name+ "&surename="+ surename + "&email="+ email , String.class);

        return newUser;
    }
       @RequestMapping("/updateUser/{username}/{password}/{name}/{surename}/{email}")
    public String updateUser(@PathVariable String username, @PathVariable String password,@PathVariable String name, @PathVariable String surename, String email){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("MY-UBER_USER", false);
        String ip = instance.getIPAddr();
        String user = this.restTemplate.getForObject("http://"+ip+":8080/update?username="+username+ "&password=" + password + "&name="+name+ "&surename="+ surename + "&email="+ email , String.class);
                

        return user;
    }
    
         @RequestMapping("/getUserByid/{id}")
        public String getUserByid(@PathVariable String id ){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("MY-UBER_USER", false);
        String ip = instance.getIPAddr();
        String UserById = this.restTemplate.getForObject("http://"+ip+":8080/getbyid?id="+id , String.class);

        return UserById;
    }
        
             @RequestMapping("/getAllUsers")
        public String getUserByid(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("MY-UBER_USER", false);
        String ip = instance.getIPAddr();
        String AllUsers = this.restTemplate.getForObject("http://"+ip+":8080/getAllUsers" , String.class);

        return AllUsers;
    }
        
                @RequestMapping("getAllUsers1")
    public String getAllUsers1(@PathVariable String idCustomer,@PathVariable String startCordinate,@PathVariable String endCordinate) {
        Random rnd = new Random();
        try{
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("MY-UBER_USER", false);
        String ip = instance.getIPAddr();
        String comments = this.restTemplate.getForObject("http://"+ip+":8080/getAllUsers" , String.class);
        return comments;
        }catch(Exception ex){
            return ex.toString();
        }
    } 
        
                 @RequestMapping("/login/{username}/{password}")
        public String getUserByid(@PathVariable String username,@PathVariable String password){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("MY-UBER_USER", false);
        String ip = instance.getIPAddr();
        String login = this.restTemplate.getForObject("http://"+ip+":8080/login?username="+ username +"&password=" + password, String.class);

        return login;
    }
        
     // USER SERVICE Driver CONTROLER  END
    
    //STARS CONTROLER 
          @RequestMapping("/rateDriver/{tripId}/{customerId}/{driverId}/{stars}/{who}")
    public String rateDriver( @PathVariable Long tripId,@PathVariable Long customerId,@PathVariable  Long driverId, @PathVariable int stars, @PathVariable int who) {
        Random rnd = new Random();
        try{
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("FEEDBACK", false);
        String ip = instance.getIPAddr();
        String comments = this.restTemplate.getForObject("http://"+ip+":8080/rateDriver?tripId="+tripId+ "&customerId="+customerId+"&driverId="+driverId+"&stars="+stars+"&who="+who , String.class);
        return comments;
        }catch(Exception ex){
            return ex.toString();
        }
    }
    
          @RequestMapping("/getAllRaitings")
    public String getAllRaitings() {
        Random rnd = new Random();
        try{
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("FEEDBACK", false);
        String ip = instance.getIPAddr();
        String comments = this.restTemplate.getForObject("http://"+ip+":8080/getAllRaitings" , String.class);
        return comments;
        }catch(Exception ex){
            return ex.toString();
        }
    }
    
            @RequestMapping("/GetAvgCustomerRaiting/{customerId}")
    public String GetAvgCustomerRaiting(@PathVariable Long customerId) {
        Random rnd = new Random();
        try{
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("FEEDBACK", false);
        String ip = instance.getIPAddr();
        String comments = this.restTemplate.getForObject("http://"+ip+":8080/GetAvgCustomerRaiting?customerId="+customerId , String.class);
        return comments;
        }catch(Exception ex){
            return ex.toString();
        }
    }
    
                @RequestMapping("/GetAvgDriverRaiting/{driverId}")
    public String GetAvgDriverRaiting(@PathVariable Long driverId) {
        Random rnd = new Random();
        try{
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("FEEDBACK", false);
        String ip = instance.getIPAddr();
        String comments = this.restTemplate.getForObject("http://"+ip+":8080/GetAvgDriverRaiting?driverId=" + driverId, String.class);
        return comments;
        }catch(Exception ex){
            return ex.toString();
        }
    }

     //STARS CONTROLER ---
     //Comment CONTROLER 
                   @RequestMapping("/commentTrip/{idTrip}/{comment}/{commenting}")
    public String commentTrip(@PathVariable String idTrip,@PathVariable String comment,@PathVariable String commenting) {
        Random rnd = new Random();
        try{
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("FEEDBACK", false);
        String ip = instance.getIPAddr();
        String comments = this.restTemplate.getForObject("http://"+ip+":8080/commentTrip?idTrip="+idTrip+"&comment="+comment+"&commenting="+commenting , String.class);
        return comments;
        }catch(Exception ex){
            return ex.toString();
        }
    }    
    
      @RequestMapping("/getComments")
    public String getComments() {
        Random rnd = new Random();
        try{
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("FEEDBACK", false);
        String ip = instance.getIPAddr();
        String comments = this.restTemplate.getForObject("http://"+ip+":8080/getComments" , String.class);
        return comments;
        }catch(Exception ex){
            return ex.toString();
        }
    }
          @RequestMapping("/getComment/{tripId}")
    public String getComment(@PathVariable String tripId) {
        Random rnd = new Random();
        try{
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("FEEDBACK", false);
        String ip = instance.getIPAddr();
        String comments = this.restTemplate.getForObject("http://"+ip+":8080/getComment?tripId="+tripId , String.class);
        return comments;
        }catch(Exception ex){
            return ex.toString();
        }
    } 

    
          @RequestMapping("/getCommentObj/{tripId}")
    public String getCommentObj(@PathVariable String tripId) {
        Random rnd = new Random();
//    InstanceInfo instance = eurekaClient.getNextServerFromEureka("FEEDBACK", false);
//        String ip = instance.getIPAddr();
//        String comments = this.restTemplate.getForObject("http://"+ip+":8080/feedback/getCommentObj?tripId=" + tripId , String.class);          
        
        //my-app1
        List<ServiceInstance> services1 = discoveryClient.getInstances("FEEDBACK");
        EurekaDiscoveryClient.EurekaServiceInstance service1 = (EurekaDiscoveryClient.EurekaServiceInstance) services1.get(rnd.nextInt(services1.size()));
        String ip1 = service1.getInstanceInfo().getIPAddr();
        String greeting1 = this.restTemplate.getForObject("http://"+ip1+":8080/getCommentObj?tripId="+tripId, String.class);

    return ip1 + " " + greeting1;
  
    }   
   
     //Comment CONTROLER  END---
    
    
    //Driver Contorleer 

        @RequestMapping("/driverRequest/{idCustomer}/{startCordinate}/{endCordinate}")
    public String driverRequest(@PathVariable String idCustomer,@PathVariable String startCordinate,@PathVariable String endCordinate) {
        Random rnd = new Random();
        try{
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("TRAVEL", false);
        String ip = instance.getIPAddr();
        String comments = this.restTemplate.getForObject("http://"+ip+":8080/driverRequest?idCustomer="+idCustomer+"&startCordinate="+ startCordinate + "&endCordinate="+endCordinate  , String.class);
        return comments;
        }catch(Exception ex){
            return ex.toString();
        }
    }
      @RequestMapping("/getAllRequests")
    public String getAllRequests() {
      
        try{
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("TRAVEL", false);
        String ip = instance.getIPAddr();
        String AllRequests = this.restTemplate.getForObject("http://"+ip+":8080/getAllRequests" , String.class);
        return AllRequests;
        }catch(Exception ex){
            return ex.toString();
        }
    } 
    @RequestMapping("/startTrip")
    public String startTrip(@PathVariable String idDriver,@PathVariable String startCordinate,@PathVariable String endCordinate,@PathVariable String idCustomer) {
      
        try{
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("TRAVEL", false);
        String ip = instance.getIPAddr();
        String startTrip = this.restTemplate.getForObject("http://"+ip+":8080/startTrip?idDriver="+idDriver+ "&startCordinate="+startCordinate+"&endCordinate="+endCordinate+"&idCustomer="+idCustomer, String.class);
        return startTrip;
        }catch(Exception ex){
            return ex.toString();
        }
    }
       @RequestMapping("/endTrip")
    public String endTrip(@PathVariable Long id, @PathVariable String idDriver,@PathVariable String startCordinate,@PathVariable String endCordinate,@PathVariable String idCustomer) {
      
        try{
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("TRAVEL", false);
        String ip = instance.getIPAddr();
        String endTrip = this.restTemplate.getForObject("http://"+ip+":8080/endTrip?id="+id+"&idDriver="+idDriver+ "&startCordinate="+startCordinate+"&endCordinate="+endCordinate+"&idCustomer="+idCustomer, String.class);
        return endTrip;
        }catch(Exception ex){
            return ex.toString();
        }
    }
    
      @RequestMapping("/getAllTrips")
    public String endTrip() {      
        try{
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("TRAVEL", false);
        String ip = instance.getIPAddr();
        String getAllTrips = this.restTemplate.getForObject("http://"+ip+":8080/getAllTrips", String.class);
        return getAllTrips;
        }catch(Exception ex){
            return ex.toString();
        }
    }
    
    //Driver Contorleer  ****
    
    
    
    
       @RequestMapping("/infof")
    public String serviceInfo(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("FEEDBACK", false);
        return instance.getIPAddr();
    }
          @RequestMapping("/infou")
    public String serviceUser(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("MY-UBER_USER", false);
        return instance.getIPAddr();
    }
       @RequestMapping("/infot")
      public String serviceTravel(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("TRAVEL", false);
        return instance.getIPAddr();
    }



}
