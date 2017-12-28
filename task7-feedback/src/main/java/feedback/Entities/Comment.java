/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback.Entities;

import java.util.stream.Stream;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Helios_1
 */
@Entity
public class Comment {

  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String idTrip;
    
    public String comment;
    private String commenting;
    
  public Comment() {
    }

    public Comment(String idTrip, String commenting) {
        this.idTrip = idTrip;
        this.commenting = commenting;
    }
     @Override
    public String toString() {
        return String.format(
                "Comment[id=%d, idTrip='%s', comment='%s', commenting='%s']",
                id, idTrip , comment, commenting);
    }
    public Comment(String idTrip, String comment, String commenting) {
      this.idTrip = idTrip;
      this.commenting = commenting;
      this.comment = comment;
      
    }

    public String getTripId() {
     return idTrip;
    }
    
}
