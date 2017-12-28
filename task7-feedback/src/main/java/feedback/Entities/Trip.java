/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback.Entities;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.rmi.CORBA.Tie;

/**
 *
 * @author Helios_1
 */
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String idDriver;
    private String StartCordinate;
    private String endCordinate;
    private String idCustomer;
    private String startTime;
    private String endTime;
    private String tripStatus;

    public Trip() {
    }

    public Trip(String idDriver, String StartCordinate, String endCordinate, String idCustomer, String startTime, String endTime) {
        this.idDriver = idDriver;
        this.StartCordinate = StartCordinate;
        this.endCordinate = endCordinate;
        this.idCustomer = idCustomer;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Trip(String idDriver, String StartCordinate, String endCordinate, String idCustomer) {
         this.idDriver = idDriver;
        this.StartCordinate = StartCordinate;
        this.endCordinate = endCordinate;
        this.idCustomer = idCustomer;
        this.startTime = "23/4/2434";
        this.endTime = "000000";
        this.tripStatus = "0";
    }

    public Trip(Long id, String idDriver, String StartCordinate, String endCordinate, String idCustomer) {
        this.id = id;
           this.idDriver = idDriver;
        this.StartCordinate = StartCordinate;
        this.endCordinate = endCordinate;
        this.idCustomer = idCustomer;
        this.startTime = "23/4/2434";
        this.endTime = "23/3/2324";
        this.tripStatus = "1";
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

    public String getIdCustomer() {
        return idCustomer;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
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

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    
    
}
