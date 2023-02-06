package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.NoteDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    //Create a method for finding all notes by 'User':
    List<NoteDto> getAllNotesByUserId(Long userId);

    //Create a method for adding a Note:
    @Transactional
    void addNote(NoteDto noteDto, Long userId);

    //Create a method for deleting a Note:
    @Transactional
    void deleteNoteById(Long noteId);

    //Create a method for updating a Note:
    @Transactional
    void updateNoteById(NoteDto noteDto);

    //Create a method for getting a note by the 'noteId':
    Optional<NoteDto> getNoteById(Long noteId);
}

//--- Created this Interface file by refactoring  all the methods from the 'NoteServiceImpl' java class file that the above listed methods are from-----
//-- From PP3- Step 2- Creating the Service Layer: --------->
