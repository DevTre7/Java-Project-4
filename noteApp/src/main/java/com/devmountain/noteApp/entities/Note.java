package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.NoteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    //Create a private type Long  'id' field w/ 'Id' and 'GeneratedValue' Annotation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Create a private type String 'body' field w/ 'Column' Annotation
    @Column(columnDefinition = "text")
    private String body;

    //Create a private type 'User' field called 'user'  w/ '@ManyToOne' and '@JsonBackReference' Annotation
    @ManyToOne
    @JsonBackReference
    private User user;

    //Generate a  Getter & Setter for the  private (type Long) 'id' field
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Generate a  Getter & Setter for the  private (type String) 'body' field
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    //This Constructor is commented out since the '@NoArgsConstructor' Annotation is implemented on line 14
    //Generate a Constructor w/ No fields (No Arguments)
            //    public Note() {
            //
            //    }

    //This Constructor is commented out since the '@AllArgsConstructor' Annotation is implemented on line 13
            //Generate a Constructor w/ All fields (ALL Arguments): 'id' and 'body'
//    public Note(Long id, String body) {
//        this.id = id;
//        this.body = body;
//    }

    //Create a Constructor that takes in the referenced DTO (NoteDto) classes as an argument
    public Note(NoteDto noteDto){
        if(noteDto.getBody() != null){
            this.body = noteDto.getBody();
        }
    }
}
