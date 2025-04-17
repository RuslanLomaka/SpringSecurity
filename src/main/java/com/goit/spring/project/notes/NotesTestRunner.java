package com.goit.spring.project.notes;

import com.goit.spring.project.exceptions.NoteNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class NotesTestRunner {
    private final NoteService noteService;

    public NotesTestRunner(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostConstruct
    public void run() {
        System.out.println("== TESTING NOTE SERVICE ==");

        Note note = new Note(1, "Hello", "Test content");
        noteService.add(note);
        System.out.println("added note:");
        System.out.println(noteService.listAll());


        note.setContent("Updated content");
        note.setTitle("Updated title");
        noteService.update(note);
        System.out.println("updated note:");
        System.out.println(noteService.listAll());

        noteService.deleteById(1);
        System.out.println("deleted note:");
        System.out.println(noteService.listAll());

        System.out.println("getting note by id 2: which doesnt exist and we should get a custom exception");

        try {
            System.out.println(noteService.getById(2));
        } catch (NoteNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("== TESTING NOTE SERVICE DONE ==");
    }
}