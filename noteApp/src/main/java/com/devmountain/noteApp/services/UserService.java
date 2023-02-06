package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.UserDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    //Create a public method that returns a “List<String>” called “addUser” that accepts a UserDto called “userDto” as an argument
    //Then Annotate the method w/ '@Transactional'
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);
}
