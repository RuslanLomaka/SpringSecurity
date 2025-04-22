package com.goit.spring.project.notes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "/note/list", method = RequestMethod.GET)
    public ModelAndView getListOfNotes() {
        ModelAndView result = new ModelAndView("note/list");
        result.addObject("pageTitle", "All notes");
        result.addObject("notes", noteService.listAll());
        result.addObject("showBackToList", false);
        return result;
    }

    @RequestMapping(value = "/note/view", method = RequestMethod.GET)
    public ModelAndView getAddNotePage(Long id) {
        ModelAndView result = new ModelAndView("note/view");
        Note note = noteService.getById(id);
        result.addObject("pageTitle", note.getTitle());
        result.addObject("note", note);
        result.addObject("showBackToList", true);
        return result;
    }

    @RequestMapping(value = "/note/add", method = RequestMethod.GET)
    public ModelAndView getAddNotePage() {
        ModelAndView result = new ModelAndView("note/add");
        result.addObject("pageTitle", "Add note");
        result.addObject("showBackToList", true);
        return result;
    }

    @PostMapping("/note/add")
    public RedirectView saveNote(@ModelAttribute Note note) {
        noteService.add(note);
        return new RedirectView("/note/list");
    }

    @RequestMapping(value = "/note/edit", method = RequestMethod.GET)
    public ModelAndView getEditPage(@RequestParam(name = "id") Long id) {
        ModelAndView result = new ModelAndView("note/edit");
        Note note = noteService.getById(id);
        result.addObject("note", note);
        result.addObject("pageTitle", "Edit note");
        result.addObject("showBackToList", true);
        return result;
    }

    @RequestMapping(value = "/note/edit", method = RequestMethod.POST)
    public String updateNote(@RequestParam(name = "id") Long id,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "content") String content) {
        Note note = new Note(id, title, content);
        noteService.update(note);
        return "redirect:/note/list";
    }

    @PostMapping("/note/delete")
    public String deleteNote(@RequestParam(name = "id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}