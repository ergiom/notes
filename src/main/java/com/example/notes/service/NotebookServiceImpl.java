package com.example.notes.service;

import com.example.notes.entity.Notebook;
import com.example.notes.error.NotebookNotFoundException;
import com.example.notes.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotebookServiceImpl implements NotebookService {

    @Autowired
    private NotebookRepository notebookRepository;

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
}
