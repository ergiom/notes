package com.example.notes.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Note {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String content;
}