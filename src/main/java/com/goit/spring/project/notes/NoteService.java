package com.goit.spring.project.notes;

import com.goit.spring.project.exceptions.NoteNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// тут все поки що на заглушках
@Service
public class NoteService {
    private List<Note> notes = new ArrayList<>();

    public List<Note> listAll() {
        return notes;
    }

    void add(Note note) {
        notes.add(note);
    }

    void deleteById(long id) {
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

    Note getById(long id) {
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
/*
List<Note> listAll() - повертає список всіх нотаток
Note add(Note note) - додає нову нотатку, генеруючи для цієї нотатки унікальний (випадковий) числовий ідентифікатор, повертає цю ж нотатку з згенерованим ідентифікатором.
void deleteById(long id) - видаляє нотатку з вказаним ідентифікатором. Якщо нотатки з ідентифікатором немає - викидає виключення.
void update(Note note) - шукає нотатку по note.id. Якщо нотатка є - оновлює для неї title та content. Якщо нотатки немає - викидає виключення.
Note getById(long id) - повертає нотатку по її ідентифікатору. Якщо нотатки немає - викидає виключення.
*/

