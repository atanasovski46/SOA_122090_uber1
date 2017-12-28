package hello.Entities;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    

//    @OneToMany
//    private List<Reservation> reservation;

    public Users(){}

    public Users(String name, String surname, String username, String password, String email) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
    }
 @Override
    public String toString() {
        return String.format(
                "Comment[id=%d, name='%s', surname='%s', username='%s', password='%s',, email='%s']",
                id, name , surname, username,password,email);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
