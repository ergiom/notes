package com.example.notes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Notebook {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn
    @ToString.Exclude
    private List<Note> notes;
}
