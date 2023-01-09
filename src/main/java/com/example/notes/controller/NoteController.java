package com.example.notes.controller;

import com.example.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteController {

    @Autowired
    private NoteRepository noteRepository;
}
