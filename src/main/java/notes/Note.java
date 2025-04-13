package notes;

import lombok.Data;


@Data
public class Note {

    //Тут я так зрозумів, поки нема Гібернейт автогенерацію зробити не вийде
    int id;

    String title;

    String content;
}
