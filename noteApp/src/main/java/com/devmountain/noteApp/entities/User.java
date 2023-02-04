package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Users")
public class User {
    //In the curly braces add the ID annotation "@Id"(in order to give the class an id) with a 'GeneratedValue' annotation w/ a strategy option defined as 'GenerationType.IDENTITY'
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;      //Create a  new 'private' member variable (aka 'field') called 'id' and is of type 'Long'

    //Create another private member variable (aka 'field') called 'username' and is of type 'String' and annotate is with the '@Column' annotation w/ a 'unique' option set to 'true'
    @Column(unique = true)
    private String username;

    //Create another private member variable (aka 'field') called 'password' and is of type 'String' with no options enabled.
    @Column
    private String password;

    //Create a private Set of type Note called 'noteSet' set equal to 'HashSet'
    //Annotate the Set w 'OneToMany' mappedBy option to 'user', then the fetch option set to 'FetchType.LAZY'....
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Note> noteSet = new HashSet<>();

    //Generate a  Getter & Setters for the above created fields : 'id', 'username', and 'password'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //Create a Constructor that takes in the referenced DTO classes as an argument
    public User(UserDto userDto){
        if(userDto.getUsername() != null){
            this.username = userDto.getUsername();
        }
        if(userDto.getPassword() != null){
            this.password = userDto.getPassword();
        }
    }

}

