package com.example.notes.service;

import com.example.notes.entity.Notebook;
import com.example.notes.error.NotebookNotFoundException;

import java.util.List;

public interface NotebookService {
    List<Notebook> getAllNotebooks();

    void saveNotebook(Notebook notebook);

    Notebook getNotebookById(Long id) throws NotebookNotFoundException;
}
