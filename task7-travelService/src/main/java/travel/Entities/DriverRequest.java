/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.Entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author Helios_1
 */
@Entity
public class DriverRequest {

    @Id
     @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private String idDriver;
    private String StartCordinate;
    private String endCordinate;
    
    public DriverRequest() {
    }

    public DriverRequest(String idDriver, String StartCordinate, String endCordinate) {
        this.idDriver = idDriver;
        this.StartCordinate = StartCordinate;
        this.endCordinate = endCordinate;
    }
      @Override
    public String toString() {
        return String.format(
                "id[id=%d, idDriver='%s', StartCordinate='%s', endCordinate='%s']",
                id,idDriver, StartCordinate, endCordinate);
    }

    public Long getId() {
        return id;
    }

    public String getIdDriver() {
        return idDriver;
    }

    public String getStartCordinate() {
        return StartCordinate;
    }

    public String getEndCordinate() {
        return endCordinate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdDriver(String idDriver) {
        this.idDriver = idDriver;
    }

    public void setStartCordinate(String StartCordinate) {
        this.StartCordinate = StartCordinate;
    }

    public void setEndCordinate(String endCordinate) {
        this.endCordinate = endCordinate;
    }
    

    
}
