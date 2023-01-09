package com.example.notes.controller;

import com.example.notes.entity.Notebook;
import com.example.notes.error.NotebookNotFoundException;
import com.example.notes.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotebookController {

    @Autowired
    private NotebookService notebookService;

    @GetMapping("/notebooks")
    public List<Notebook> fetchNotebooks() {
        return notebookService.getAllNotebooks();
    }

    @PostMapping("/notebooks/new")
    public void saveNotebook(@RequestBody Notebook notebook){
        notebookService.saveNotebook(notebook);
    }

    @GetMapping("/notebooks/{id}")
    public Notebook fetchNotebookById(@PathVariable("id") Long id) throws NotebookNotFoundException {
        return notebookService.getNotebookById(id);
    }

    @DeleteMapping("/notebooks/{id}")
    public void deleteNotebook(@PathVariable("id") Long id) {
        notebookService.deleteNotebookById(id);
    }

    @PutMapping("/notebooks/{id}")
    public void updateNotebook(@PathVariable("id") Long id, @RequestBody Notebook notebook) throws NotebookNotFoundException {
        notebookService.updateNotebookById(id, notebook);
    }
}
