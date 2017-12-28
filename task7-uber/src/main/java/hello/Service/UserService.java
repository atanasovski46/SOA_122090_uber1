package hello.Service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import hello.Entities.Users;
import hello.Repository.UserRepo;


@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Users findUsersByUsername(String username) {
        return userRepo.findByUsername(username).stream().findFirst().orElse(null);
    }
    public Users save(String username, String name, String surname,String password,String email) {
        Users user =  findUsersByUsername(username);
        if(user == null){
            user = new Users( name, surname, username, password,email);
        }else{
            user.setName(name);
            user.setSurname(surname);
            user.setPassword(password);
        }
        return userRepo.save(user);
    }

    public Users login(String username, String password) {
        List<Users> usersByUsername = userRepo.findByUsername(username.toLowerCase());

        if(usersByUsername != null ){
            Users user = usersByUsername.get(0);
            if(passwordEncoder.matches(password, user.getPassword()))
                return user;
        }
        return null;
    }

    public Users updateUser(Long id, String fname, String lname,String email) {
        Users userOld = userRepo.findOne(id);
        userOld.setName(fname);
        userOld.setEmail(email);
        userOld.setSurname(lname);

        return userRepo.save(userOld);
    }

    public Users findUserByID(Long id) {
        return userRepo.findOne(id);
    }

    public Iterable<Users> findAllUsers() {
        return userRepo.findAll();
    }

}
