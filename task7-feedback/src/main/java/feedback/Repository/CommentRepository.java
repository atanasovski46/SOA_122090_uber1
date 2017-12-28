/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback.Repository;

import feedback.Entities.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Helios_1
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

//    List<Customer> findByLastName(String lastName);
}
