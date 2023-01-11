package com.example.notes.service;

import com.example.notes.entity.Note;
import com.example.notes.entity.Notebook;
import com.example.notes.error.NoteNotFoundException;
import com.example.notes.error.NotebookNotFoundException;

import java.util.List;

public interface NotebookService {
    List<Notebook> getAllNotebooks();

    void saveNotebook(Notebook notebook);

    Notebook getNotebookById(Long id) throws NotebookNotFoundException;

    void deleteNotebookById(Long id);

    void updateNotebookById(Long id, Notebook notebook) throws NotebookNotFoundException;

    void saveNoteToNotebook(Long notebookId, Note note) throws NotebookNotFoundException;

    List<Note> fetchNotesFromNotebook(Long notebookId) throws NotebookNotFoundException;

    Note getNoteFromNotebook(Long notebookId, Long noteId) throws NotebookNotFoundException, NoteNotFoundException;
}
