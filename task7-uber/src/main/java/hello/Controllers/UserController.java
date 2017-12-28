package hello.Controllers;


import com.google.common.collect.FluentIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hello.Entities.Users;

import hello.Service.UserService;
import java.util.List;

import javax.servlet.http.HttpSession;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Helios on 12/14/2017.
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return counter.incrementAndGet() + "";
    }


    @RequestMapping(value= "/createNewUser", method = RequestMethod.GET)
    public Users CreateNew(@RequestParam String username, @RequestParam String password, @RequestParam String name, @RequestParam String surename, @RequestParam String email ) throws Exception {
        Users user = userService.findUsersByUsername(username);
        if( user != null)
            throw new Exception("Username taken");
        return userService.save(username, name,surename, passwordEncoder.encode(password),email);
    }


    @RequestMapping(value= "/update", method = RequestMethod.GET)
    public Users UpdateUser(@RequestParam String username, @RequestParam String password,@RequestParam String name, @RequestParam String surename, @RequestParam String email) throws Exception {
        Users user = userService.findUsersByUsername(username);
        if( user != null)
            throw new Exception("No user was found");
        return userService.save(username, name,surename, passwordEncoder.encode(password),email);
    }

    @RequestMapping("/getbyid")
    public Users getById(@RequestParam(value="id", defaultValue = "-1") Long id) {
        Users userFound = userService.findUserByID(id);
        return userFound;
    }
  @RequestMapping("/getAllUsers")
    public String getAllUsers() {
        Iterable<Users> messageReturn = userService.findAllUsers();
        
        List<Users> allUsers =  FluentIterable.from(messageReturn).toList();

        return allUsers.toString();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginUser(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password){

        if(!username.trim().isEmpty() && !password.trim().isEmpty())
        {
            Users user = userService.login(username, password);
            if(user != null)
            {
                return user.toString();
            }
            else 
                return "User found but password is wrong";

        }
         return "Yust return something";
    }


}
