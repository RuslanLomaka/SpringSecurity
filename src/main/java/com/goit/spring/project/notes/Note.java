package com.goit.spring.project.notes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Note {

    //Тут я так зрозумів, поки нема Гібернейт автогенерацію зробити не вийде
    long id;

    String title;

    String content;
    @Override
    public String toString(){
    return "Note{" + "id=" + id + ", title='" + title + '\'' + ", content='" + content + '\'' + '}';
    }

}
