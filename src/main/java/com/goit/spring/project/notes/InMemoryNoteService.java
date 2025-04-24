package com.goit.spring.project.notes;

import com.goit.spring.project.exceptions.NoteNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class InMemoryNoteService implements NoteServiceInterface{


    private long nextId = 1;
    private final List<Note> notes = new ArrayList<>();

    public List<Note> listAll() {
        return notes;
    }

    public void add(Note note) {
        note.setId(nextId++);
        notes.add(note);
    }

    public void deleteById(long id) {
        notes.removeIf(note -> note.getId() == id);
    }

    public void update(Note note) {
        for (Note note1 : notes) {
            if (note1.getId() == note.getId()) {
                note1.setContent(note.getContent());
                note1.setTitle(note.getTitle());
            }
        }
    }

   public  Note getById(long id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        throw new NoteNotFoundException("Note with id [" + id + "] not found");
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Notes:\n");
        for (Note note : notes) {
            sb.append(note);
        }
        sb.append("\n");
        return sb.toString();
    }
}