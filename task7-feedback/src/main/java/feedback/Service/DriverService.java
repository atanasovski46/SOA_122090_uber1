/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback.Service;

import java.util.List;
import feedback.Entities.DriverRequest;
import feedback.Repository.DriverRepository;
import feedback.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import feedback.Entities.Trip;
import feedback.Repository.TripRepository;

/**
 *
 * @author aveli
 */

@Service
public class DriverService  {
    
    private final DriverRepository driverRepository;
     private final TripRepository tripRepository;
    
    @Autowired
    public DriverService(DriverRepository driverRepository,TripRepository tripRepository) {
        this.driverRepository = driverRepository;
        this.tripRepository = tripRepository;
    }
    public String DrivingRequest(String idCustomer, String StartCordinate, String endCordinate ){
        //Zapishi vo baza request       
                DriverRequest driverRequest = new DriverRequest(idCustomer, StartCordinate,endCordinate);
                driverRepository.save(driverRequest);
                
                // find all free driver and send them request for drivig
                // send to gateway 
        return "This Driving request was written in database" + idCustomer + " " + StartCordinate;
    }
    
     public String sendInviteToDriver(String idDriver, String StartCordinate, String endCordinate ){
        //Zapishi vo baza request
        return "This send invite do driver request was written in database" + idDriver + " " + StartCordinate;
    }
     
      public String startTrip(String idDriver, String StartCordinate, String endCordinate,String idCustomer ){
        //Zapishi vo baza request
         Trip trip = new Trip(idDriver, StartCordinate, endCordinate,idCustomer);
                tripRepository.save(trip);
        
        return "This start Trip request was written in database" + idDriver + " " + StartCordinate;
    }
       public String endTrip(Long id,String idDriver, String StartCordinate, String endCordinate,String idCustomer ){
        //Zapishi vo baza request
          Trip tripOne = new Trip(id,idDriver, StartCordinate, endCordinate,idCustomer);
          
         tripRepository.save(tripOne);
        return "This  end Trip request was written in database";
    }

    public List<DriverRequest> getAllRequests() {
        List <DriverRequest> AllDrivingRequest = (List<DriverRequest>) driverRepository.findAll();
        return AllDrivingRequest;
    }
    
     public List<Trip> getAllTrips() {
        List <Trip> AllTrips = (List<Trip>) tripRepository.findAll();
        return AllTrips;
    }
}
