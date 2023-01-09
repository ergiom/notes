package com.example.notes.controller;

import com.example.notes.entity.Note;
import com.example.notes.error.NotebookNotFoundException;
import com.example.notes.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NotebookService notebookService;

    @GetMapping("/notebooks/{notebook_id}/notes")
    public List<Note> fetchAllNotesInNotebook(@PathVariable("notebook_id") Long notebookId) throws NotebookNotFoundException {
        return notebookService.fetchNotesFromNotebook(notebookId);
    }

    @PostMapping("/notebooks/{notebook_id}/notes")
    public void saveNoteToNotebook(@PathVariable("notebook_id") Long notebookId,
                                   @RequestBody Note note) throws NotebookNotFoundException {
        notebookService.saveNoteToNotebook(notebookId, note);
    }
}
