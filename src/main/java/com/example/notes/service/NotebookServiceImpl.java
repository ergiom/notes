package com.example.notes.service;

import com.example.notes.entity.Note;
import com.example.notes.entity.Notebook;
import com.example.notes.error.NoteNotFoundException;
import com.example.notes.error.NotebookNotFoundException;
import com.example.notes.repository.NoteRepository;
import com.example.notes.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotebookServiceImpl implements NotebookService {

    @Autowired
    private NotebookRepository notebookRepository;
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Notebook> getAllNotebooks() {
        return notebookRepository.findAll();
    }

    @Override
    public void saveNotebook(Notebook notebook) {
        notebookRepository.save(notebook);
    }

    @Override
    public Notebook getNotebookById(Long id) throws NotebookNotFoundException {
        Optional<Notebook> notebookOptional = notebookRepository.findById(id);

        if (notebookOptional.isEmpty()) {
            throw new NotebookNotFoundException();
        }

        return notebookOptional.get();
    }

    @Override
    public void deleteNotebookById(Long id) {
        notebookRepository.deleteById(id);
    }

    @Override
    public void updateNotebookById(Long id, Notebook notebook) throws NotebookNotFoundException {
        Optional<Notebook> notebookOptional = notebookRepository.findById(id);

        if (notebookOptional.isEmpty()) {
            throw new NotebookNotFoundException();
        }

        Notebook oldNotebook = notebookOptional.get();

        if (notebook.getName() != null) {
            oldNotebook.setName(notebook.getName());
        }

        notebookRepository.save(oldNotebook);
    }

    @Override
    public void saveNoteToNotebook(Long notebookId, Note note) throws NotebookNotFoundException {
        Notebook notebook = getNotebookById(notebookId);
        notebook.addNote(note);
        notebookRepository.save(notebook);
    }

    @Override
    public List<Note> fetchNotesFromNotebook(Long notebookId) throws NotebookNotFoundException {
        Notebook notebook = getNotebookById(notebookId);
        return notebook.getNotes();
    }

    @Override
    public Note getNoteFromNotebook(Long notebookId, Long noteId) throws NoteNotFoundException, NotebookNotFoundException {
        Notebook notebook = getNotebookById(notebookId);
        Optional<Note> optionalNote = noteRepository.findById(noteId);
        if (optionalNote.isEmpty()) {
            throw new NoteNotFoundException();
        }
        Note note = optionalNote.get();

        if (!notebook.getNotes().contains(note)) {
            throw new NoteNotFoundException();
        }

        return note;
    }
}
