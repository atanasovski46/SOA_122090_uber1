package feedback.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import feedback.Entities.Stars;
import feedback.Repository.StarsRepository;
import feedback.Service.StarsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarsController {

//    @Autowired
//    StarsRepository starsRepository;
//
//    @Autowired
//    StarsService starsService;
 private final StarsService starsService;
    public StarsController(StarsService starsService) {
           this.starsService = starsService;
    }
    
    
 @RequestMapping("/rateDriver")
    public Stars CreateNew(@RequestParam(value = "tripId") Long tripId,@RequestParam(value = "customerId") Long customerId, @RequestParam(value = "driverId") Long driverId, int stars,int who){
        return starsService.rateTrip(tripId,customerId, driverId, stars, who);
    }
    
//    @RequestMapping("/rateCustomer")
//    public Stars CreateNew(@RequestParam(value = "userId") Long userId, @RequestParam(value = "driverId") Long driverId, int stars){
//        return starsService.rateTrip(userId, driverId, stars);
//    }
    
     @RequestMapping("/getAllRaitings")
    public String getAllRaitings(){
        return starsService.getAllRaitings().toString() ;
    }

    @RequestMapping("/GetAvgCustomerRaiting")
    public double GetAvgCostumerRaiting(@RequestParam(defaultValue = "-1")Long customerId) {
        return starsService.findAverageRatingOnCostumer(customerId);
    }
    
     @RequestMapping("/GetAvgDriverRaiting")
    public double GetAvgDriverRaiting(@RequestParam(defaultValue = "-1")Long driverId) {
        return starsService.findAverageRatingOnDriver(driverId);
    }

    @RequestMapping("/GetTotalCustomerRaiting")
    public long getTotalUserRatings(@RequestParam(defaultValue = "-1")Long userId) {
        return starsService.getTotalCostumerRatings(userId);
    }
     @RequestMapping("/GetTotalDriverRaiting")
    public long GetTotalDriverRaiting(@RequestParam(defaultValue = "-1")Long driverId) {
        return starsService.getTotalDriverRatings(driverId);
    }


}
