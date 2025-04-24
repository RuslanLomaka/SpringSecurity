package com.goit.spring.project.notes;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "note")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" + "id=" + id + ", title='" + title + '\'' + ", content='" + content + '\'' + '}';
    }


}