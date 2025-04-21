package com.goit.spring.project.notes;

import org.springframework.stereotype.Component;

@Component
public class TestNoteLoader {
    public TestNoteLoader(NoteService noteService) {
        System.out.println("Loading test notes...");
        noteService.add(new Note("test note 1", "Test content"));
        noteService.add(new Note("test note 2", "Test content2"));
        System.out.println("Test notes loaded.");
    }
}