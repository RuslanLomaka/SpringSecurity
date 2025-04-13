package notes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteStervice {


 List<Note> notes;

 public NoteStervice() {

 }

 public NoteStervice(List<Note> notes) {

 }

 public List<Note> listAll() {
     return notes;
 }

 public void update(Note note){

 }

    /*
 Методи заглушки дя подальшої роботи з БД
     */


}
