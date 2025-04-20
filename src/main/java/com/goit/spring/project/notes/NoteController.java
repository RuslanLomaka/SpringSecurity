package com.goit.spring.project.notes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "/note/list", method = RequestMethod.GET)
    public ModelAndView getListOfNotes() {
        ModelAndView result = new ModelAndView("note/list");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @RequestMapping(value = "/note/view", method = RequestMethod.GET)
    public ModelAndView getAddNotePage(Long id) {
        ModelAndView result = new ModelAndView("note/view");
        Note note = noteService.getById(id);
        result.addObject("note", note);
        return result;
    }


}
