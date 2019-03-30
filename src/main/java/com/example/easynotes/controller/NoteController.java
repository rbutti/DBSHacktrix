package com.example.easynotes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.dao.LoginDAOImpl;
import com.example.easynotes.model.LoginRequest;
import com.example.easynotes.model.Note;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api")
public class NoteController {

   @Autowired
   LoginDAOImpl dao;

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return new ArrayList<Note>();
    }
    
    
//    @GetMapping("/loans")
//    public List<Loan> getLoanStatus() {
//        return new ArrayList<Loan>();
//    }
    
    @PostMapping("/login")
    public ResponseEntity getLoginDetails(@RequestBody LoginRequest login) {
    	
    	return ResponseEntity.ok(dao.login(login));
    }
    

//    
//    @PostMapping("/getDefaulterList")
//    public ResponseEntity createNote(@RequestBody DefaulterList defaulter) {
//    	ResponseEntity<DefaulterList> re = new ResponseEntity<DefaulterList>(HttpStatus.ACCEPTED);
//    	return re;
//    }
//    
//    @GetMapping("/getPersonDetails")
//    public ResponseEntity<PersonDetails> getPersonDetails(@PathParam(value = "customerId") String customerId) {
//    	PersonDetails  pr = new PersonDetails();
//    	return ResponseEntity.ok(pr);
//    }
//    
//    @GetMapping("/getLoanDetails")
//    public ResponseEntity<LoanDetails> getLoanDetails(@PathParam(value = "customerId") String customerId) {
//    	LoanDetails  pr = new LoanDetails();
//    	return ResponseEntity.ok(pr);
//    }
//    
//    @GetMapping("/getUserDetails")
//    public ResponseEntity<LoanDetails> getUserDetails(@PathParam(value = "userId") String userId) {
//    	LoanDetails  pr = new LoanDetails();
//    	return ResponseEntity.ok(pr);
//    }

    /*@GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }*/
//
//    @PutMapping("/notes/{id}")
//    public Note updateNote(@PathVariable(value = "id") Long noteId,
//                                           @Valid @RequestBody Note noteDetails) {
//
//        Note note = noteRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//
//        note.setTitle(noteDetails.getTitle());
//        note.setContent(noteDetails.getContent());
//
//        Note updatedNote = noteRepository.save(note);
//        return updatedNote;
//    }
//
//    @DeleteMapping("/notes/{id}")
//    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
//        Note note = noteRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//
//        noteRepository.delete(note);
//
//        return ResponseEntity.ok().build();
//    }
}
