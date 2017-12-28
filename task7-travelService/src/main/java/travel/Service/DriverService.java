/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.Service;

import java.util.List;
import travel.Entities.DriverRequest;
import travel.Repository.DriverRepository;
import travel.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import travel.Entities.Trip;
import travel.Repository.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;




@Service
public class DriverService  {
    @Autowired
     private final DriverRepository driverRepository;
     private final TripRepository tripRepository;
    
    
    @Autowired
    public DriverService(DriverRepository driverRepository,TripRepository tripRepository) {
        this.driverRepository = driverRepository;
        this.tripRepository = tripRepository;

    }
    
    public String DrivingRequest(String idCustomer, String StartCordinate, String endCordinate ){
      
                DriverRequest driverRequest = new DriverRequest(idCustomer, StartCordinate,endCordinate);
                driverRepository.save(driverRequest);

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
       //  tripRepository.save(tripOne);
        if(tripRepository.findOne(id) != null){
                Trip oldTrip = tripRepository.findOne(id);
                Date now = new Date();
               oldTrip.setEndTime(now.toString());
               oldTrip.setTripStatus("1");
               return "Trip with that id not found" +  new Date().toString();
        }
        return "Trip Ended at: " + new Date().toString();
    }

    public Iterable<DriverRequest> getAllRequests() {
           Iterable<DriverRequest> AllDriveRequests = driverRepository.findAll();
           return AllDriveRequests;
    }
    
     public Iterable<Trip> getAllTrips() {
      
          Iterable<Trip> AllTrips = tripRepository.findAll();
           return AllTrips;
    }
}
