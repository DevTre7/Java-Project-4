package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.UserDto;
import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// <<---------------------Project Part (PP)3- Step 2- Creating the Service Layer: -------------------------------------->
//Create a 'UserServiceImpl' Java class file, then create a public field w/ the '@Service' annotation
@Service
public class UserServiceImpl implements UserService {

    // (PP3- Step 2- Creating the Service Layer: --------->
    //Create private 'UserRepository userRepository' field and annotate it w/ '@Autowired'
    @Autowired
    private UserRepository userRepository;

    // PP3- Step 2- Creating the Service Layer: --------->
    //Create private 'PasswordEncoder passwordEncoder' field and annotate it w/ '@Autowired'
    @Autowired
    private PasswordEncoder passwordEncoder;

    //Create a public method that returns a “List<String>” called “addUser” that accepts a UserDto called “userDto” as an argument
    //Then Annotate the method w/ '@Transactional'
    @Override
    @Transactional
    public List<String> addUser(UserDto userDto){
        List<String> response = new ArrayList<>();
        User user = new User(userDto);
        userRepository.saveAndFlush(user);
        response.add("http://localhost:8080/login.html");
        return response;
    }

    @Override
    public List<String> userLogin(UserDto userDto){
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if (userOptional.isPresent()){
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())){
                response.add("http://localhost:8080/login.html");
                response.add(String.valueOf(userOptional.get().getId()));
            } else {
                response.add("Username or password incorrect");
            }
        } else {
            response.add("Username or password incorrect");
        }
        return response;

    }

}
