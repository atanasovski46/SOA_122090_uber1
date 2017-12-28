package feedback.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import feedback.Entities.Stars;
import feedback.Repository.StarsRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Service
public class StarsService {

    @Autowired
    StarsRepository starsRepository;

   
    public Stars rateTrip(Long tripId,Long userId,Long driverId,int stars, int who) {
        Stars starsNew = new Stars(tripId,userId, driverId,stars,who);
     
        return starsRepository.save(starsNew);
    }
    
    
       public Iterable<Stars> getAllRaitings() {
           Iterable<Stars> AllStars = starsRepository.findAll();
           return AllStars;
    }

    public double findAverageRatingOnCostumer(Long userId) {
        Iterable<Stars> allstars = starsRepository.findAll();
        Stream<Stars> targetStream = StreamSupport.stream(allstars.spliterator(), false);

        return targetStream
                .filter((Stars s) -> Objects.equals(s.getRatedUserId(), userId) && Objects.equals(s.getWho(),0) )            
                .mapToInt((Stars s) -> s.getStars())
                .average().orElse(0);
    }
    
     public double findAverageRatingOnDriver(Long driverId) {
        Iterable<Stars> allstars = starsRepository.findAll();
        Stream<Stars> targetStream = StreamSupport.stream(allstars.spliterator(), false);

        return targetStream
                .filter((Stars s) -> Objects.equals(s.getRatedDriverId(), driverId) && Objects.equals(s.getWho(),1))
                .mapToInt((Stars s) -> s.getStars())
                .average().orElse(0);
    }

    public long getTotalCostumerRatings(Long userId) {
        Iterable<Stars> allstars = starsRepository.findAll();
        Stream<Stars> targetStream = StreamSupport.stream(allstars.spliterator(), false);

        return targetStream
                .filter(s -> Objects.equals(s.getRatedUserId(), userId) && Objects.equals(s.getWho(),0))
                .count();
    }
   public long getTotalDriverRatings(Long driverId) {
        Iterable<Stars> allstars = starsRepository.findAll();
        Stream<Stars> targetStream = StreamSupport.stream(allstars.spliterator(), false);

        return targetStream
                .filter(s -> Objects.equals(s.getRatedDriverId(), driverId) && Objects.equals(s.getWho(),1))
                .count();
    }


   
 
}
