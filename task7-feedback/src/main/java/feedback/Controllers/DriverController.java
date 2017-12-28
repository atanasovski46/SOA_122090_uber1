/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback.Controllers;

import java.util.List;
import feedback.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aveli
 */

@RestController
public class DriverController {
    
    private final DriverService driverService;
    
    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
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
    public String getAllRequests() {
    List messageReturn = driverService.getAllRequests();
      String listString = "";
       for (Object s : messageReturn)
{
    listString += s + "\t";
}
        return "True" + messageReturn;
    }
    
    @RequestMapping("/sendInviteToDriver")
    public String sendInviteToDriver(@RequestParam(value="idDriver")String idDriver,@RequestParam(value="startCordinate") String startCordinate, @RequestParam(value="endCordinate") String endCordinate) {
    String messageReturn = driverService.sendInviteToDriver(idDriver,  startCordinate,  endCordinate);
        return "True" + messageReturn;
    }
    
    
    
      @RequestMapping("/startTrip")
    public String startTrip(String idDriver, String startCordinate, String endCordinate, String idCustomer) {
    String messageReturn = driverService.startTrip(idDriver, startCordinate, endCordinate,idCustomer);
        return "True" + messageReturn;
    }
    
     @RequestMapping("/endTrip")
    public String endTrip(Long id,String idDriver, String startCordinate, String endCordinate,String idCustomer) {
    String messageReturn = driverService.endTrip(id,idDriver, startCordinate, endCordinate,idCustomer);
        return "True" + messageReturn;
    }
    
      @RequestMapping("/getAllTrips")
    public String getAllTrips() {
    List messageReturn = driverService.getAllTrips();
    String listString = "";
   for (Object s : messageReturn)
{
    listString += s + "\t";
}
        return "True" + listString;
    }
}
