/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.Entities.Trip;
import travel.Repository.TripRepository;

/**
 *
 * @author Helios_1
 */
@Service
public class TripService {
    @Autowired
    TripRepository tripRepository;
    
      @Autowired
    public TripService(TripRepository tripRepository) {
      
        this.tripRepository = tripRepository;
    }
        public String startTrip(String idDriver, String StartCordinate, String endCordinate,String idCustomer ){
        //Zapishi vo baza request
         Trip trip = new Trip(idDriver, StartCordinate, endCordinate,idCustomer);
                tripRepository.save(trip);
        
        return "This start Trip request was written in database" + idDriver + " " + StartCordinate;
    }
    
}
