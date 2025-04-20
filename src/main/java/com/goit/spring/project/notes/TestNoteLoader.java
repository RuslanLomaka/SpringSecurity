package com.goit.spring.project.notes;

import org.springframework.stereotype.Component;

@Component
public class TestNoteLoader {
    public TestNoteLoader(NoteService noteService) {
        System.out.println("Loading test notes...");
        noteService.add(new Note(1, "Hello", "Test content"));
        noteService.add(new Note(2, "Hello2", "Test content2"));
        System.out.println("Test notes loaded.");
    }
}