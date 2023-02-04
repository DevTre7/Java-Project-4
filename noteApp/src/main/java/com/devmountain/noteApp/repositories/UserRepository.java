package com.devmountain.noteApp.repositories;

import com.devmountain.noteApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Annotate the 'UserRepository' Interface with  '@Repository'
//Then have the Interface extend to 'JpaRepository' that accept 2 types within the carets ('< >'); 'User' anf 'Long'
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
