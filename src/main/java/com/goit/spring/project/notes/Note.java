package com.goit.spring.project.notes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Note {
    public Note() {
    }
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
    long id;
    String title;
    String content;
    @Override
    public String toString(){
    return "Note{" + "id=" + id + ", title='" + title + '\'' + ", content='" + content + '\'' + '}';
    }
}
