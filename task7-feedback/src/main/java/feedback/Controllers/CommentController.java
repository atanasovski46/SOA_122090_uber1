/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback.Controllers;


import com.google.common.collect.FluentIterable;
import feedback.Entities.Comment;
import feedback.Service.CommentService;
import java.util.List;
import java.util.stream.StreamSupport;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    
    private final CommentService commentService;
    
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    
    @RequestMapping("/commentTrip")
    public String Index(String idTrip,String comment,String commenting){
        String messageReturn = commentService.CommentTrip(idTrip,  comment, commenting );
        return "This is the comment for the Trip "+ messageReturn;
    }
        @RequestMapping("/getComments")
    public String getComments(){
        Iterable<Comment> messageReturn = commentService.GetAllComments();
        List<Comment> asdf =  FluentIterable.from(messageReturn).toList();

        return "This are all comments in the database "+ asdf.toString();
    }
    
            @RequestMapping("/getCommentsObj")
    public List<Comment> getCommentsObj(){
        Iterable<Comment> messageReturn = commentService.GetAllComments();
        List<Comment> asdf =  FluentIterable.from(messageReturn).toList();

        return asdf;
    }
    
          @RequestMapping("/getComment")
    public String getComment(String tripId){
        Comment comment = commentService.GetCommentByTrip(tripId);
    
        return "This is the comment for the Trip with id: " + tripId + " </br> " + comment.toString() ;
    }
    
             @RequestMapping("/getCommentObj")
    public Comment getCommentObj(String tripId){
        Comment comment = commentService.GetCommentByTrip(tripId);
    
        return comment;
    }
    

}
