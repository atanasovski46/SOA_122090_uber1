/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback.Service;

import feedback.Entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import feedback.Entities.Comment;
import feedback.Repository.DriverRepository;
import feedback.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import feedback.Entities.Trip;
import feedback.Repository.TripRepository;

import feedback.Repository.CommentRepository;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 *
 * @author Helios_1
 */
@Service
public class CommentService {
        private final CommentRepository commentRepository;
    
    @Autowired
      public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;    
    }
    public String CommentTrip(String id, String commentText, String commenting){
        Comment comment = new Comment(id, commentText, commenting);
         
        commentRepository.save(comment);
        
        return "This is a comment " + id + " " + commentText + " " + commenting + " ";
        
    }

    public Iterable<Comment> GetAllComments() {
        return commentRepository.findAll();
    }

    public Comment GetComment(Long id) {
    
        return commentRepository.findOne(id);
    }
    public Comment GetCommentByTrip(String tripId){
        Iterable<Comment> allComments = commentRepository.findAll();
          Stream<Comment> targetStream = StreamSupport.stream(allComments.spliterator(), false);
        Comment comment = targetStream
                .filter(s -> (s.getTripId() == null ? tripId == null : s.getTripId().equals(tripId)) )
                .findFirst()
                .orElse(null);
        
        return comment;
    }
    
}
