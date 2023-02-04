package com.devmountain.noteApp.dtos;


import com.devmountain.noteApp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//Annotate the 'UserDto' class w/ the '@Data', '@AllArgsConstructor', and '@NoArgsConstructor' annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
//Have the 'UserDto' class implement the 'Serializable' Interface
public class UserDto implements Serializable {

    //Create 4 Private fields/ (member variables) w/o any Annotations: 'id, username, password, noteDtoSet'
    private Long id;                //<<--Private field of 'Long' Type called 'id'
    private String username;        //<<--Private field of 'String' Type called 'username'
    private String password;        //<<--Private field of 'String' Type called 'password'
    private Set<NoteDto> noteDtoSet = new HashSet<>();      //<<--Private field of 'Set<NoteDto>' Type called 'noteDtoSet'


    public UserDto(User user) {
        if (user.getId() != null){
            this.id = user.getId();
        }
        if(user.getUsername() != null){
            this.username = user.getUsername();
        }
        if(user.getPassword() != null){
            this.password = getPassword();
        }
    }
}
