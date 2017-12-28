package feedback.Entities;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Stars {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long driverId;
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    private long tripId;
    private int stars;
    private int who; // Who rated it

   
    public Stars(){}

    public Stars( Long tripId, Long userId, Long driverId, int stars,int who) {
        this.userId = userId;
        this.driverId = driverId;
        this.dateCreated = new Date();
        this.stars = stars;
        this.tripId = tripId;
        this.who = who;
    }

    
   @Override
    public String toString() {
        return String.format(
                "Star[id=%d, tripId='%s', userId='%s', driverId='%s', stars='%s', Who rated it='%s']",
                id,tripId, userId, driverId, stars, who);
    }
    public void setTripId(long tripId) {
        this.tripId = tripId;
    }
 public int getWho() {
        return who;
    }

    public long getTripId() {
        return tripId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Long getRatedUserId() {
        return userId;
    }
    
     public Long getRatedDriverId() {
        return driverId;
    }
//
//    public void setRatedItemId(Long ratedItemId) {
//        this.ratedItemId = ratedItemId;
//    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    


}