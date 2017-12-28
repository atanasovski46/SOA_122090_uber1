/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import travel.Entities.Trip;
/**
 *
 * @author aveli
 */
@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {

//    List<Customer> findByLastName(String lastName);
}
