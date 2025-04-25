package com.goit.spring.project.notes;

import com.goit.spring.project.exceptions.NoteNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;

@Primary
@Service
public class JpaNoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public JpaNoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    @Override
    public void add(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public void update(Note note) {
        noteRepository.save(note);
    }

    @Override
    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note with id [" + id + "] not found"));
    }
}
