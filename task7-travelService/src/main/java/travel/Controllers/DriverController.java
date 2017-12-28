/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.Controllers;

import java.util.List;
import travel.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import travel.Service.TripService;


@RestController
public class DriverController {
    
    private final DriverService driverService;
    private final  TripService tripService;
    @Autowired
    public DriverController(DriverService driverService, TripService tripService) {
        this.driverService = driverService;
        this.tripService = tripService;
        
    }
    
    @RequestMapping("/driver")
    public String Index(){
        return "Driver controller from uber-app1";
    }

    public DriverService getDriverService() {
        return driverService;
    }
    
    @RequestMapping("/driverRequest")
    public String drivingRequest(@RequestParam(value="idCustomer")String idCustomer,@RequestParam(value="startCordinate") String startCordinate, @RequestParam(value="endCordinate") String endCordinate) {
    String messageReturn = driverService.DrivingRequest(idCustomer,  startCordinate,  endCordinate);
        return "True" + messageReturn;
    }
     @RequestMapping("/getAllRequests")
    public String getAllDrivingRequests() {
 
        return driverService.getAllRequests().toString();
    }
    
    @RequestMapping("/sendInviteToDriver")
    public String sendInviteToDriver(@RequestParam(value="idDriver")String idDriver,@RequestParam(value="startCordinate") String startCordinate, @RequestParam(value="endCordinate") String endCordinate) {
    String messageReturn = driverService.sendInviteToDriver(idDriver,  startCordinate,  endCordinate);
        return "True" + messageReturn;
    }  
  
      @RequestMapping("/startTrip")
    public String startTrip(String idDriver, String startCordinate, String endCordinate, String idCustomer) {
    String messageReturn = tripService.startTrip(idDriver, startCordinate, endCordinate,idCustomer);
        return "True" + messageReturn;
    }
    
     @RequestMapping("/endTrip")
    public String endTrip(Long id,String idDriver, String startCordinate, String endCordinate,String idCustomer) {
    String messageReturn = driverService.endTrip(id,idDriver, startCordinate, endCordinate,idCustomer);
        return "True" + messageReturn;
    }
    
      @RequestMapping("/getAllTrips")
    public String getAllTrips() { 
    return driverService.getAllTrips().toString();
    }

}